package requests

import java.net.URL
import java.util.stream.Collectors


enum class MonobankRequest(private val url: String) {
    CONNECT("https://api.monobank.ua/bank/currency");

    private var content:String = ""

    fun getCurrency(mnemonic: Mnemonic): MonobankCurrency {
        return getAllCurrencies().stream()
            .filter { it.currencyCodeA == mnemonic.getCode() && it.currencyCodeB == Mnemonic.UAH.getCode() }.findAny()
            .get()
    }

    private fun getAllCurrencies(): ArrayList<MonobankCurrency> {
        var list = ArrayList<String>()
        var json = getAllCurrenciesAsString()
        json = json.substring(1, json.length - 1)
        val array = json.split("},")
        list.addAll(array)
        list = list.stream().map { "$it}" }.collect(Collectors.toList()) as ArrayList<String>
        return list.stream().map(this::getCurrencyFromJsonObj)
            .collect(Collectors.toList()) as ArrayList<MonobankCurrency>
    }

    private fun getCurrencyFromJsonObj(obj: String): MonobankCurrency {
        val fields = obj.split(",")
        var a = 0
        var b = 0
        var date = 0
        var buy = 0.0
        var sell = 0.0
        fields.forEach {
            when {
                it.contains("currencyCodeA") -> a = it.split(":")[1].toInt()
                it.contains("currencyCodeB") -> b = it.split(":")[1].toInt()
                it.contains("date") -> date = it.split(":")[1].toInt()
                it.contains("rateBuy") -> buy = checkForDouble(it.split(":")[1]).toDouble()
                it.contains("rateSell") -> sell = checkForDouble(it.split(":")[1]).toDouble()
            }
        }
        return MonobankCurrency(a, b, date, buy, sell)
    }

    private fun checkForDouble(s:String):String {
        if (s.contains(".")) {
            return s.split(".")[0].plus(".").plus(s.split(".")[1]
                .toList().stream().limit(2).map { "$it" }
                .collect(Collectors.joining("")))
        }
        return s
    }

    private fun getAllCurrenciesAsString(): String {
        if (content.isEmpty()) {
            content = URL(url).readText()
        }
        return content
    }
}

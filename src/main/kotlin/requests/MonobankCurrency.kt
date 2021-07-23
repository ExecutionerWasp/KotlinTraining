package requests

class MonobankCurrency(
   val currencyCodeA: Int,
   val currencyCodeB: Int,
   val date: Int,
   val rateBuy: Double,
   val rateSell: Double
) {

    override fun toString(): String {
        return """
            |BUY : $rateBuy, 
            |SELL : $rateSell
            |""".trimMargin()
    }
}

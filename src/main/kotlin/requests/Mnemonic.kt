package requests

enum class Mnemonic(private val code:Int) {
    USD(840),
    EUR(978),
    UAH(980);

    fun getCode(): Int {
        return code
    }
}

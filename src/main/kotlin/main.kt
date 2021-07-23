import requests.Mnemonic
import requests.MonobankRequest
import java.util.logging.Logger

val log: Logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)

fun main(args: Array<String>) {
    requestTraining()
}

fun requestTraining() {
    println("EUR \n${MonobankRequest.CONNECT.getCurrency(Mnemonic.EUR)}")
    println("USD \n${MonobankRequest.CONNECT.getCurrency(Mnemonic.USD)}")
}

import requests.Mnemonic
import requests.MonobankRequest
import java.util.logging.Logger
import java.util.stream.Collectors

val log: Logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)

fun main(args: Array<String>) {
    requestTraining()
}

fun requestTraining() {
    println("EUR \n${MonobankRequest.CONNECT.getCurrency(Mnemonic.EUR)}")
    println("USD \n${MonobankRequest.CONNECT.getCurrency(Mnemonic.USD)}")
}

fun collectionTraining() {
    val collection = ArrayList<Int>()
    collection.add(1)
    collection.add(2)
    collection.add(3)
    collection.add(4)
    val result = collection
        .stream()
        .map { Value(it) }
        .map { "${it.getValue()}" }
        .collect(Collectors.joining(","))
    log.info(result)
    log.info("Sum ${collectionSum(collection)}")
}

fun collectionSum(collection: Collection<Int>): Int {
    return collection.stream().mapToInt { it }.sum()
}

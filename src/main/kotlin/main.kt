import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reflection.Employee
import reflection.Instance
import reflection.ReflectionProcessor
import requests.Mnemonic
import requests.MonobankRequest
import spring.BlogApplication

fun main(args: Array<String>) {
    runApplication<BlogApplication>(*args)
}

@SuppressWarnings("unchecked")
@Deprecated(message = "For training: call reflection")
fun reflectionTraining() {
    val reflect = ReflectionProcessor()
    val annotation = Instance::class.java
    val invoked = reflect.invokeWithAnnotation(
        Employee("name", 1, 1000.0), annotation as Class<Any>,
        ArrayList<Any>()
    )
    println(invoked)
}

@Deprecated(message = "For training: call monobank currency exchange")
fun requestTraining() {
    println("EUR \n${MonobankRequest.CONNECT.getCurrency(Mnemonic.EUR)}")
    println("USD \n${MonobankRequest.CONNECT.getCurrency(Mnemonic.USD)}")
}

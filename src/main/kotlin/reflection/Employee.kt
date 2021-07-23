package reflection

@Mark("entity")
class Employee(
    val name:String,
    val age:Int,
    val salary:Double
) {

    @Instance
    fun createEmptyObject():Employee {
        println("Created empty object")
        return Employee("", 0, 0.0)
    }

    override fun toString(): String {
        return "Employee(name='$name', age=$age, salary=$salary)"
    }
}

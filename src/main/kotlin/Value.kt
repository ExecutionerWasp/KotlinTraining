class Value(x:Int) {
    private val value:Int = x

    fun getValue():Int {
        return this.value
    }

    override fun toString(): String {
        return "$value"
    }
}

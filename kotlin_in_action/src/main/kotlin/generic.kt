class MutableStack<E>(vararg items: E) {
    private val element = items.toMutableList()

    fun push(e: E) = element.add(e)
    operator fun plus(e: E) = push(e)

    fun pop(): E = element.removeAt(0)

    fun size() = element.size;

    fun isEmpty():Boolean {
        when(element.size){
            0 -> println("-- this is empty")
            1 -> println("-- only one element exists")
            else -> println("-- size : ${element.size}")
        }
        return element.isEmpty()
    }

    override fun toString() = "MutableStack : ${element.joinToString(" ")}"

    // for * in 형식으로 사용 가능.
    operator fun iterator() = element.iterator()
}

fun main() {
    val stack = MutableStack(1,2,3)
    for (i in 2..10 step 2){            // step range
        stack + i
    }
    for (i in stack) {                  // iterator usage
        println("print : $i")
    }

    for (i in 0 until 3) {              // 0,1,2 range
        stack + i
    }

    while (!stack.isEmpty()) {
        println("pop: ${stack.pop()} , size : ${stack.size()}")
    }
}
package function

// open means allow inheritance
open class Animal(
    val name: String,    // immutable    Nonnull
    var age: Int,       // mutable      Nonnull
    val gender: Boolean?   //immutable Nullable
) {
    private val likesList = mutableListOf<Animal>()

    open fun introduce(
        vararg description: String, // vararg
        header: String = name,     // default value
        isBoy: Boolean?             // nullable
    ) {
        println("[$header] $description , $isBoy")      // 'Unit' is a type with only one value
    }

    // single-expression function
    fun printLikesList() =
        println("$name 가 좋아하는 동물들 :  ${likesList.map { a -> a.name }.toTypedArray().contentToString()}")

    // infix function, only single parameter
    infix fun like(target: Animal) {
        this.likesList.add(target)
    }

    // operator function, can use with operator like (in, =, *, < ..)
    operator fun contains(target: Animal) = likesList.contains(target)

}

class Cat(name: String, age: Int, gender: Boolean?) : Animal(name = name, age = age, gender = gender) {
    override fun introduce(vararg description: String, header: String, isBoy: Boolean?) {
        super.introduce(
            *description,       // array가 아닌 vararg로 넘어가게 함
            header = "I am a cat",          // vararg 뒤의 named 파라미터 사용가능.
            isBoy = isBoy
        )
    }
}

class Dog(name: String, age: Int, gender: Boolean?) : Animal(name = name, age = age, gender = gender) {
}


fun main() {
    val 밤비 = Cat("밤비", 3, true)
    val 호두 = Dog("호두", 7, true)
    // infix function
    밤비 like 호두
    밤비.printLikesList()

    // operator function
    println(밤비 in 호두)
    println(호두 in 밤비)

    val pair = 밤비 to 호두
    println(pair)
}
var age: Int = 18
    set(value) {
        if ((value > 0) and (value <110))
            field = value
    }
data class Item(
    val id: Int,
    val name: String,
    val quantity: Int) {
    override fun toString(): String {
        return "Id предмета: $id\nИмя: $name\nКоличество: $quantity\n"
    }
}
abstract class Human(val name: String){
    open fun hello(){
        println("My name is: $name")
    }
}
abstract class Figure {
    abstract fun perimetr(): Float
    abstract fun area(): Float
}
class Rectangle(val width: Float, val height: Float): Figure(){
    override fun perimetr(): Float {
        return 2 * (width+height)
    }
    override fun area(): Float {
        return width*height
    }
}
class Person(name: String, var age: Int): Human(name) {
    override fun hello(){
        println("My name is $name")
    }
}
fun main() {
    /*println(age)
    age = 45
    println(age)
    age = -35
    println(age)

    val sword = Item(1, "Sword", 1)
    val betterSword = sword.copy(quantity = 2)
    println(sword.toString())
    println(betterSword.toString())

    val(id,name,quantity) = betterSword
    println("Id предмета: $id\nИмя: $name\nКоличество: $quantity\n")*/

//    val Markus: Human
//    val Kera: Human = Human("Alice")
    val connor: Person = Person(name ="Connor", age = 20)
    val markus: Human = Person(name = "Markus", age = 18)
    connor.hello()
    markus.hello()
}

interface Movable{
    fun move()
}
class Car: Movable {
    override fun move() {
        println("едем на машине")
    }
}
class Aircraft: Movable {
    override fun move() {
        println("летим на самолете")
    }
}
fun travel(obj: Movable) = obj.move()
fun main() {
    val car: Movable = Car()
    val aircraft: Movable = Aircraft()
    car.move()
    aircraft.move()
    travel(car)
    travel(aircraft)
}

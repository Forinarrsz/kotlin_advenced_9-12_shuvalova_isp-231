package example

interface Movable{
    var speed: Int
    val model: String
    val number: String
    fun move()
    fun stop() {
        println("станавливаемся...")
    }
}
interface Worker{
    fun work()
}
interface Student {
    fun study()
}
interface VideoPlayable {
    fun play() = println("Play video")
}
interface AudioPlayable {
    fun play() = println("Play Audio")
}

class MediaPlayer: VideoPlayable, AudioPlayable {
    override fun play() {
        println("start playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}

class WorkingStudent(val name: String) : Worker, Student {
    override fun work() = println("$name working")
    override fun study() = println("$name studying")
}
class Car(override val model: String, override val number: String): Movable {
  override var speed = 60
    override fun move() {
        println("едем на машине со скоростью $speed км/ч")
    }
}
class Aircraft(override val model: String, override val number: String): Movable {
    override var speed = 650
    override fun move() {
        println("летим на самолете со скоростью $speed км/ч")
    }
    override  fun stop() {
        println("приземляемся...")
    }
}
fun travel(obj: Movable) = obj.move()
fun main() {
    val car = Car("Tesla", "Model X")
    val aircraft = Aircraft("boeing", "737")
    car.move()
    aircraft.move()
    travel(car)
    travel(aircraft)

    val connor = WorkingStudent("Connor")
    connor.work()
    connor.study()

    val player = MediaPlayer()
    player.play()
}

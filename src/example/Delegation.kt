package example
import kotlin.properties.Delegates


interface Base {
    fun someFun()
}
class BaseImpl(): Base {
    override fun someFun() {}

}
class Deriverd(someBase: Base) : Base by someBase

interface Messenger{
    fun sendTextMessage()
    fun sendVideoMessage()
}

class InstantMessenger(val programName: String) : Messenger {
    override fun sendTextMessage() = println("send text message")
    override fun sendVideoMessage() = println("send video message")
    }

class Smartphone (val name: String, m: Messenger): Messenger by m{
    override fun sendTextMessage() = println("Send sms")
}

interface PhotoDevice{
    fun takePhoto()
}

class PhotoCamera: PhotoDevice {
    override fun takePhoto() = println("Take a photo")
}

var counter: Int by Delegates.observable(0) {
    _, old, new -> println("счетчик изменился: $old -> $new")
}

class User {
    var name: String by Delegates.observable("<no name>") {
            _, old, new -> println("имя изменено: $old -> $new")
    }
}
fun main(){
    val vk = InstantMessenger("vk")
    //val photoCamera = PhotoCamera()
    val googlePixel = Smartphone("google pixel", vk)
    googlePixel.sendTextMessage()
    googlePixel.sendVideoMessage()

    counter = 1
    counter = 5
}
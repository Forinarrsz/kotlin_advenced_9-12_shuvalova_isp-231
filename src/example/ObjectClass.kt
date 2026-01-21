package example

import java.awt.Color
import javax.sound.midi.MetaMessage

object GameSession {
    init {
        println("Игровая сессия создана")
    }
    var isActie: Boolean = false
    fun start(){
        isActie = true
        println("Игра началась")
    }
    fun end() {
        isActie = false
        println("Игра завершена")
    }
}
object Logger {
    var count = 0
    fun log(message: String) {
        count++
        println("[$count] $message")
    }
}
object AppSettings {
    val version = "1.0.0"
    var isDarkMode = true

    fun togglrTheme() {
        isDarkMode = !isDarkMode
    }
    fun checkTheme(){
        if(AppSettings.isDarkMode) {
            println("Тёмная тема включена")
        }
    }
}

object Colors {
    const val RED = "#FF0000"
    const val GREEN = "#OOFFOO"
    const val BLUE = "#OOOOFF"
}

class MyCar(val model: String) {
    fun drive() = println("$model driving")
}

object TrafficController {
    var carcount = 0
    fun carPassed(){
        carcount++
    }
}

fun main(){
    println("Программа запущена")
    println("Проверяем состояние, но не трогаем GameSession")
    println("Теперь запускаем игру")
    GameSession.start()
    println("Проверяем состояние еще раз")
    println("Активна ли сессия: ${GameSession.isActie}")

    //logger

    Logger.log("first message")
    Logger.log("second message")

    val logger1 = Logger
    val logger2 = Logger
    println(logger1 == logger2)
    //colors
    println(Colors.RED)
    println(Colors.GREEN)
    println(Colors.BLUE)
    //handler
    val handler = object {
        val name = "Обработчик"
        fun handle() {
            println("обрабатываю...")
        }
    }
    println(handler.name)
    handler.handle()

    //class or object
    MyCar("BMW")
    MyCar("Tesla")
    TrafficController.carPassed()
}
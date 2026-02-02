package example
import kotlin.properties.Delegates

//class UserProfile(initialName: String, initialEmail: String){}

class GameHero(startName: String){
    var name: String by Delegates.observable(startName){
            _, old, new -> println("${old} получил новое имя: $new")
    }
    var mana: Int by Delegates.observable(100){
            _, old, new -> println("МАНА: $old -> $new")
    }
    val Ultimate: String by lazy {
        println("Loading animation...")
        "Метеоритный дождь"
    }
}

fun main() {
    println("Create hero...")
    val hero = GameHero("Sky Breaker")
    println("Mana: ${hero.mana}")
    println("hero using ultimate...")
    println("ultimate: ${hero.Ultimate}")
    println("repeat using ultimate")
    println("ultimate: ${hero.Ultimate}")
    println("change name")
    hero.name = "Jake Sully"
    println("hero hill mana")
    hero.mana = 250
}
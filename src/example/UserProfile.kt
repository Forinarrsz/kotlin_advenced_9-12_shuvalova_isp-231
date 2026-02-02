package example
import kotlin.properties.Delegates

class UserProfile(initialName: String, initialEmail: String){
    var name: String by Delegates.observable(initialName){
            _, old, new -> println("имя изменено: $old -> $new")
    }

    var email: String by Delegates.observable(initialEmail){
            _, old, new -> println("email изменен: $old -> $new")
    }

    val avatar: String by lazy {
        println("загружается аватар для $name...")
        "avatar_of_$name.png"
    }




}
fun main(){
    println("create profile...")
    val user = UserProfile( initialName = "Connor","connor@mail.com")

    println("\nname: ${user.name}")
    println("Email: ${user.email}")
    println("Обращаемся к аватару впервые")
    println(user.avatar)
    println("Обращаемся к аватару снова (взят из кэша)")
    println(user.avatar)
    println("Меняем email")
    user.email = "connorandroid@pochta.ru"
    println("меняем имя")
    user.name ="Connor RK800"

    }
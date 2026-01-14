abstract class OutpostModule (val name: String,
var level: Int = 1)
{ abstract fun performAction(manager: ResourceManager)
    fun upgrade() {
        level++
        println("$name улучшен до уровня $level")

    }


}
import Modules.EnergyGenerator
import Modules.ModuleResult
import Modules.ResearchLab
import resources.OutpostResource
import resources.ResourceManager

fun main(){

    val manager = ResourceManager()
    val minerals = OutpostResource(1, "Minerals",300)
    val gas = OutpostResource(2, "Gas", 100)

    manager.add(minerals)
    manager.add(gas)
    manager.PrintAll()
    val bonus = minerals.copy(amountInit = minerals.amount + 50)
    println("Копия минералов с бонусом: $bonus")

    val manager2 = ResourceManager()
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    manager2.add(OutpostResource(1, "Minerals", 120))
    manager2.add(OutpostResource(2, "Gas", 40))
    generator.performAction(manager2)
    lab.performAction(manager2)
    println()
    manager2.PrintAll()

    println("ШАГ 6:")
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handleModuleResult(generatorResult)
    handleModuleResult(labResult)
    println()
    manager2.PrintAll()



    val loadedresourses = FileStorage.load()
    loadedresourses.forEach { manager.add(it) }

    if(loadedresourses.isEmpty()){
        manager.add(OutpostResource(1,"minerals",300))
        manager.add(OutpostResource(2,"gas",200))
    }
    FileStorage.save(manager.getAll())
}
fun handleModuleResult(result: ModuleResult) {
    when (result) {
        is ModuleResult.Success -> println("УСПЕХ: ${result.message}")
        is ModuleResult.ResourceProduced -> println("Произведено: ${result.resourseName} + ${result.amount}")
        is ModuleResult.NotEnoughResources ->
            println(
                "Недостаточно ресурса: ${result.resourseName} " + "НужноЖ ${result.required}, есть: ${result.available}"
            )
        is ModuleResult.Error ->
            println("ОШИБКА: ${result.reason}")
    }
    logger.log("запуск базы")

}
object SystemLogger{
    init {
        println("systemlogger инициализирован")
    }
    fun log(message: String){
        println("[log] $message")
    }
}
val logger by lazy { SystemLogger }

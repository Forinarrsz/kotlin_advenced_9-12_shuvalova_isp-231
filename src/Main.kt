import Modules.EnergyGenerator
import Modules.ResearchLab

fun main(){
    val manager = ResourceManager()
    val minerals = OutpostResource(1, "Minerals",300)
    val gas = OutpostResource(2, "Gas", 100)

    manager.add(minerals)
    manager.add(gas)
    manager.PrintAll()
    val bonus = minerals.copy(amount = minerals.amount + 50)
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
}

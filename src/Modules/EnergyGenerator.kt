package Modules
import OutpostResource
import ResourceManager
import OutpostModule

class EnergyGenerator: OutpostModule("Генератор энергии"){
    override fun performAction(manager: ResourceManager) {
        println("генератор работает... производит 20 энергии")
        val energy = manager.get("Energy")
        if (energy != null) {
            energy.amount += 20
        }
        else {
            manager.add(OutpostResource(99, "Energy", 20))
        }
    }
}
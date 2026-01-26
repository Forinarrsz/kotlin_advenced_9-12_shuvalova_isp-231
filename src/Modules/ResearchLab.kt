package Modules

import resources.ResourceManager
class ResearchLab : OutpostModule("Исследовательская лаборатория") {
    override fun performAction(manager: ResourceManager): ModuleResult {
        val minerals = manager.get("Minerals")

        if (minerals == null || minerals.amount < 30) {
            //println("недостаточно минералов для исследования")
            return ModuleResult.NotEnoughResources(
                resourseName = "Minerals",
                required = 30,
                available = minerals?.amount ?: 0
            )
        }

        minerals.amount -= 30
        //println("Лаборатория проводит исследование (минералы -30)")}
        return ModuleResult.Success("Исследование завершено")
    }
}
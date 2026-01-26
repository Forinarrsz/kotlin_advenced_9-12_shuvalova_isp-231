package Modules

sealed class ModuleResult {
    data class Success(val message: String) : ModuleResult()
    data class ResourceProduced(val resourseName: String, val amount: Int) : ModuleResult()

    data class NotEnoughResources(
        val resourseName: String,
        val required: Int,
        val available: Int) : ModuleResult()
    data class Error(val reason: String): ModuleResult()
}
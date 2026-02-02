package outpostState

class OutpostManager {
    private val resourcesList = mutableListOf<ObservableResource>()

    init {
        println("Менеджер аванпоста инициализирован.")
    }

    fun addResource(resource: ObservableResource) {
        resourcesList.add(resource)
    }

    val resources: List<ObservableResource> by lazy {
        println("Список ресурсов инициализирован.")
        resourcesList
    }
}

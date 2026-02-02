package outpostState

fun main() {
    val manager = OutpostManager()

    val minerals = ObservableResource("Minerals")
    val wood = ObservableResource("Wood")

    manager.addResource(minerals)
    manager.addResource(wood)

    val observer1 = ResourceObserver(minerals)
    val observer2 = ResourceObserver(wood)

    minerals.quantity = 100
    wood.quantity = 50

    val stateStorage = StateStorage("outpost_state.txt")
    stateStorage.saveState(manager.resources)

    val loadedResources = stateStorage.loadState()
    loadedResources.forEach { resource ->
        println("Ресурс ${resource.name} имеет количество ${resource.quantity}.")
    }
}

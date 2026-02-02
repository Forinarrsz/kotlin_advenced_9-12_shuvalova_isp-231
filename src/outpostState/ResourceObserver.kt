package outpostState

class ResourceObserver(private val resource: ObservableResource) {
    init {
        resource.quantity = resource.quantity
        resource.quantityChangedListener = { oldValue, newValue ->
            println("Наблюдатель: Ресурс ${resource.name} изменён: $oldValue → $newValue")
        }
    }
}

package outpostState
/*
import kotlin.properties.Delegates

class ObservableResource(val name: String) {
    var quantity: Int by Delegates.observable(0) { _, oldValue, newValue ->
        println("Ресурс $name изменён: $oldValue → $newValue")
    }
}
*/
import kotlin.properties.Delegates

class ObservableResource(val name: String) {
    var quantity: Int by Delegates.observable(0) { _, oldValue, newValue ->
        println("Ресурс $name изменён: $oldValue → $newValue")
        quantityChangedListener?.invoke(oldValue, newValue)
    }

    var quantityChangedListener: ((oldValue: Int, newValue: Int) -> Unit)? = null
}

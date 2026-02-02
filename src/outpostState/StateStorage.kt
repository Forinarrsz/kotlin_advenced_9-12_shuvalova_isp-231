package outpostState
import java.io.File

class StateStorage(private val filePath: String) {
    fun saveState(resources: List<ObservableResource>) {
        File(filePath).bufferedWriter().use { out ->
            for (resource in resources) {
                out.write("${resource.name},${resource.quantity}\n")
            }
        }
        println("Состояние сохранено.")
    }

    fun loadState(): List<ObservableResource> {
        val resources = mutableListOf<ObservableResource>()
        File(filePath).forEachLine { line ->
            val (name, quantity) = line.split(",")
            val resource = ObservableResource(name).apply { this.quantity = quantity.toInt() }
            resources.add(resource)
        }
        println("Состояние загружено.")
        return resources
    }
}

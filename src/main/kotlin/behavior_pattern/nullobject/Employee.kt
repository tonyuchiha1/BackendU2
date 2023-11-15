package behavior_pattern.nullobject

class Employee {
    companion object {
        // Definimos una constante NULL_EMPLOYEE que representa un empleado nulo.
        val NULL_EMPLOYEE = Employee(0L, "EMPLEADO DESCONOCIDO", Address.NULL_ADDRESS)
    }

    // Propiedades privadas que representan las características del empleado.
    private var id: Long? = null
    private var name: String? = null
    internal var address: Address? = null

    // Constructor principal que inicializa las propiedades del empleado.
    constructor(id: Long, name: String, address: Address) {
        this.id = id
        this.name = name
        this.address = address
    }

    // Constructor secundario sin parámetros.
    constructor()

    // Métodos para acceder y modificar las propiedades del empleado.
    fun getId(): Long? {
        return id
    }

    fun setId(id: Long) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getAddress(): Address? {
        return address
    }

    fun setAddress(address: Address) {
        this.address = address
    }
}

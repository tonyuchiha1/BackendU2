package behavior_pattern.nullobject

class Employee {
    companion object {
        val NULL_EMPLOYEE = Employee(0L, "EMPLEADO DESCONOCIDO", Address.NULL_ADDRESS)
    }

    private var id: Long? = null
    private var name: String? = null
    internal var address: Address? = null

    constructor(id: Long, name: String, address: Address) {
        this.id = id
        this.name = name
        this.address = address
    }

    constructor()

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

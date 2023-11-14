package behavior_pattern.nullobject

class Address {
    companion object {
        val NULL_ADDRESS = Address("NOT ADDRESS")
    }

    var fullAddress: String? = null

    constructor(fullAddress: String) {
        this.fullAddress = fullAddress
    }

    fun obtenerDireccionCompleta(): String? {
        return fullAddress
    }
}

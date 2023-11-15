package behavior_pattern.nullobject

class Address {
    companion object {
        // Definimos una constante NULL_ADDRESS que representa una dirección nula.
        val NULL_ADDRESS = Address("NOT ADDRESS")
    }

    // Propiedad que almacena la dirección completa.
    var fullAddress: String? = null

    // Constructor primario que inicializa la dirección completa.
    constructor(fullAddress: String) {
        this.fullAddress = fullAddress
    }

    // Función que devuelve la dirección completa. Puede devolver null.
    fun obtenerDireccionCompleta(): String? {
        return fullAddress
    }
}

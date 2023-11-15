package behavior_pattern.state

// Clase abstracta que representa un estado del servidor.
abstract class AbstractServerState {
    // Constructor por defecto.
    constructor()

    // Método abstracto para manejar mensajes en un estado específico.
    abstract fun handleMessage(server: Server, message: String)
}

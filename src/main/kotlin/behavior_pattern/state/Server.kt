package behavior_pattern.state

import behavior_pattern.patronstatepackage.StopServerState
class Server {
    // Propiedades privadas que definen el estado del servidor.
    private val maxRequest = 5
    private val messageProcess = MessageProcess(this)
    private var serverState: AbstractServerState? = null

    // Bloque de inicialización.
    init {
        // Inicializa el estado del servidor con el estado "StopServerState".
        setState(StopServerState(this))
    }

    // Método para manejar mensajes. Delega la responsabilidad al estado actual del servidor.
    fun handleMessage(message: String) {
        serverState?.handleMessage(this, message)
    }

    // Método para obtener el límite máximo de solicitudes.
    fun getMaxRequest(): Int {
        return maxRequest
    }

    // Método para obtener el proceso de mensajes del servidor.
    fun getMessageProcess(): MessageProcess {
        return messageProcess
    }

    // Método para obtener el estado actual del servidor.
    fun getState(): AbstractServerState? {
        return serverState
    }

    // Método para establecer el estado del servidor.
    fun setState(newState: AbstractServerState) {
        this.serverState = newState
        println("Server change state > ${this.serverState?.javaClass?.simpleName}")
    }

    // Método para cambiar el estado del servidor a uno específico.
    fun changeStateTo(newState: AbstractServerState) {
        setState(newState)
    }
}

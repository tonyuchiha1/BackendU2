package behavior_pattern.patronstatepackage

import behavior_pattern.state.AbstractServerState
import behavior_pattern.state.Server

class StopServerState(server: Server) : AbstractServerState() {

    // Bloque de inicialización.
    init {
        // Detiene el proceso de mensajes del servidor.
        server.getMessageProcess().stop()
    }

    // Implementación del método abstracto de AbstractServerState.
    override fun handleMessage(server: Server, message: String) {
        // Imprime un mensaje indicando que el servidor está detenido.
        println("The server is stopped")
    }
}

package behavior_pattern.state

class StartServerState(server: Server) : AbstractServerState() {

    // Bloque de inicialización.
    init {
        // Inicia el proceso de mensajes del servidor.
        server.getMessageProcess().start()
    }

    // Implementación del método abstracto de AbstractServerState.
    override fun handleMessage(server: Server, message: String) {
        // Intenta encolar el mensaje en el proceso de mensajes del servidor.
        val isSaturated = server.getMessageProcess().queueMessage(message)

        // Verifica si el proceso de mensajes del servidor está saturado.
        if (!isSaturated) {
            // Si está saturado, cambia el estado del servidor a "SaturatedServerState".
            server.setState(SaturatedServerState(server))
        }
    }
}


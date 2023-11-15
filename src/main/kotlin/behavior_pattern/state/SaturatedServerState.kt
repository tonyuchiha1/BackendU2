package behavior_pattern.state

class SaturatedServerState(server: Server) : AbstractServerState() {
    // Hilo para monitorear el estado del servidor.
    private val monitoringThread: Thread

    // Bloque de inicialización.
    init {
        // Inicia el proceso de mensajes del servidor.
        server.getMessageProcess().start()

        // Inicia un hilo de monitoreo.
        monitoringThread = Thread {
            try {
                // Bucle de monitoreo.
                while (true) {
                    // Verifica si la cantidad de mensajes en proceso es menor que el límite establecido por el servidor.
                    if (server.getMessageProcess().countMessage() < server.getMaxRequest()) {
                        // Cambia el estado del servidor a "StartServerState" y sale del bucle.
                        server.setState(StartServerState(server))
                        break
                    }
                }
            } catch (e: Exception) {
                println(e.message)
            }
        }

        // Inicia el hilo de monitoreo.
        monitoringThread.start()
    }

    // Implementación del método abstracto de AbstractServerState.
    override fun handleMessage(server: Server, message: String) {
        // Imprime un mensaje indicando que el servidor está saturado y no puede procesar la solicitud.
        println("Can't process request, Server Saturated")
    }
}

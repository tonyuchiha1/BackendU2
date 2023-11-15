package behavior_pattern.state
class StartingServerState(private val server: Server) : AbstractServerState() {

    // Bloque de inicialización.
    init {
        // Inicia un hilo para manejar el proceso de inicio del servidor.
        Thread {
            try {
                // Imprime un mensaje indicando que el servidor se está iniciando.
                println("Server Starting")

                // Duerme durante 10 segundos simulando el proceso de inicio.
                Thread.sleep(1000 * 10)

                // Verifica si la cantidad de mensajes en proceso es mayor o igual al límite establecido por el servidor.
                if (server.getMessageProcess().countMessage() >= server.getMaxRequest()) {
                    // Si es así, cambia el estado del servidor a "SaturatedServerState".
                    server.changeStateTo(SaturatedServerState(server))
                } else {
                    // Si no, cambia el estado del servidor a "StartServerState".
                    server.changeStateTo(StartServerState(server))
                }

                // Imprime un mensaje indicando que el servidor se ha iniciado.
                println("Server Start")
            } catch (e: Exception) {
                // Manejo de excepciones si es necesario
            }
        }.start()
    }

    // Implementación del método abstracto de AbstractServerState.
    override fun handleMessage(server: Server, message: String) {
        // En este estado, el manejo de mensajes consiste en encolar el mensaje en el proceso de mensajes del servidor.
        server.getMessageProcess().queueMessage(message)
    }
}

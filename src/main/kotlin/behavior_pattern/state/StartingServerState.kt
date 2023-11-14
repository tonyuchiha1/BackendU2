package behavior_pattern.state
class StartingServerState(private val server: Server) : AbstractServerState() {

    init {
        Thread {
            try {
                println("Server Starting")
                Thread.sleep(1000 * 10)
                if (server.getMessageProcess().countMessage() >= server.getMaxRequest()) {
                    server.changeStateTo(SaturatedServerState(server))
                } else {
                    server.changeStateTo(StartServerState(server))
                }
                println("Server Start")
            } catch (e: Exception) {
                // Manejo de excepciones si es necesario
            }
        }.start()
    }

    override fun handleMessage(server: Server, message: String) {
        server.getMessageProcess().queueMessage(message)
    }
}

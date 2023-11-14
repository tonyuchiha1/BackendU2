package behavior_pattern.state

class SaturatedServerState(server: Server) : AbstractServerState() {
    private val monitoringThread: Thread

    init {
        server.getMessageProcess().start()

        monitoringThread = Thread {
            try {
                while (true) {
                    if (server.getMessageProcess().countMessage() < server.getMaxRequest()) {
                        server.setState(StartServerState(server))
                        break
                    }
                }
            } catch (e: Exception) {
                println(e.message)
            }
        }

        monitoringThread.start()
    }

    override fun handleMessage(server: Server, message: String) {
        println("Can't process request, Server Saturated")
    }
}

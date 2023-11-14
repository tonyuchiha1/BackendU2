package behavior_pattern.state

class StartServerState(server: Server) : AbstractServerState() {

    init {
        server.getMessageProcess().start()
    }

    override fun handleMessage(server: Server, message: String) {
        val isSaturated = server.getMessageProcess().queueMessage(message)
        if (!isSaturated) {
            server.setState(SaturatedServerState(server))
        }
    }
}

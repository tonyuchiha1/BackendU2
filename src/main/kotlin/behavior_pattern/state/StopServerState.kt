package behavior_pattern.patronstatepackage

import behavior_pattern.state.AbstractServerState
import behavior_pattern.state.Server

class StopServerState(server: Server) : AbstractServerState() {

    init {
        server.getMessageProcess().stop()
    }

    override fun handleMessage(server: Server, message: String) {
        println("The server is stopped")
    }
}

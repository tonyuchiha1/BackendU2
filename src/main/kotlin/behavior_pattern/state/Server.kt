package behavior_pattern.state

import behavior_pattern.patronstatepackage.StopServerState

class Server {
    private val maxRequest = 5
    private val messageProcess = MessageProcess(this)
    private var serverState: AbstractServerState? = null

    init {
        setState(StopServerState(this))
    }

    fun handleMessage(message: String) {
        serverState?.handleMessage(this, message)
    }

    fun getMaxRequest(): Int {
        return maxRequest
    }

    fun getMessageProcess(): MessageProcess {
        return messageProcess
    }

    fun getState(): AbstractServerState? {
        return serverState
    }

    fun setState(newState: AbstractServerState) {
        this.serverState = newState
        println("Server change state > ${this.serverState?.javaClass?.simpleName}")
    }

    fun changeStateTo(newState: AbstractServerState) {
        setState(newState)
    }
}

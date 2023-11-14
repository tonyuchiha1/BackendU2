package behavior_pattern.state

abstract class AbstractServerState {
    constructor()

    abstract fun handleMessage(server: Server, message: String)
}

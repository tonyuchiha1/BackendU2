package structural_pattern.Decorator

class TextMessage ( override var content: String): IMessage {
    override fun processMessage(): IMessage {
        return this
    }
}

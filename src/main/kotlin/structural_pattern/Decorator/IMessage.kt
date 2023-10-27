package structural_pattern.Decorator

interface IMessage {
    fun processMessage(): IMessage
    var content: String
}
package structural_pattern.Decorator

class SOAPHeaderDecorator (message:IMessage,val user: User): MessageDecorator(message) {
    override fun processMessage(): IMessage {
        message = message.processMessage()
        message = includeHeader()
        return message
    }

    private fun includeHeader(): IMessage {
        val header="<soapenv:Header>"+
                "User : \n"+user.name+"\n"
                "Password :  "+ user.password +
                "<soapenv:Header/>"
      val content = message.content.replace("<soapenv:Header/>",header)
        return  TextMessage(content)
    }
}
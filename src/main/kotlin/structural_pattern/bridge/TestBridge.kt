package structural_pattern.bridge

fun main(){
    val aesImpl:IMessageEncrypt =MessageEncryptImpl(
        AESEncryptAlgorithm())
    val desImpl: IMessageEncrypt = MessageEncryptImpl(
        DESEncryptAlgorithm())
    val noImpl: IMessageEncrypt = MessageEncryptImpl(
        NoEncryptAlgorithm())
    try {
        val message = "{\"fullname\": \"Antonio de jesus jimenez perez\", \"age\":25}"
        val messageAES = aesImpl.encryptMessage(message, "AG58YZ3CR9123458")
        println("messageAES > $messageAES\n")
        val messageDES = desImpl.encryptMessage(message, "XMzDdG4D03CKm21x")
        println("messageDES > $messageDES\n")
        val messageNO = noImpl.encryptMessage(message, "")
        println("messageNO > $messageNO\n")

    }catch ( e: Exception){
        e.printStackTrace()
    }
}
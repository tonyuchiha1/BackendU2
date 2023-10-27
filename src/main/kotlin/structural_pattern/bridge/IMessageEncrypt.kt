package structural_pattern.bridge

interface IMessageEncrypt {
    fun encryptMessage(message:String,password:String):String
   }
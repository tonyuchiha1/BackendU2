package structural_pattern.bridge

class NoEncryptAlgorithm: IEncryptAlgorithm {
    override fun encrypt(message:String,password:String):String {

    return message
        }
}
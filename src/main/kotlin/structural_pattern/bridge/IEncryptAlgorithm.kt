package structural_pattern.bridge

interface IEncryptAlgorithm {
     fun encrypt(message:String,password:String):String
}
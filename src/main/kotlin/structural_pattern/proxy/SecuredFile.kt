package structural_pattern.proxy

class SecuredFile : IFile {
    private val normalFile= NormalFile()
    var password:String=""
    override fun read(name: String) {
        if (password == "secret"){
            println("password is correct: $password")
            normalFile.read(name)
        }else{
            println("Incorrect password, Access denied:")
        }
    }
}
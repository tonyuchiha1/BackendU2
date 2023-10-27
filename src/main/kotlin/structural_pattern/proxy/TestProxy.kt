package structural_pattern.proxy

fun main(){
    val securedFile= SecuredFile()
    securedFile.read("readme.md")

    securedFile.password= "secret"
    securedFile.read("readme.md")

    val user= "tonyuchiha"
    val password ="t0pSecr3et"
    val process=1
    val processExecutor=ServiceFactory.createProcessExecutor()
    try{
        processExecutor.executeProcess(process,user,password)
    }catch (e:Exception){
        println(e.message)
    }
}

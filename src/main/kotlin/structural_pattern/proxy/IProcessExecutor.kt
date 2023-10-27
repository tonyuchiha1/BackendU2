package structural_pattern.proxy

interface IProcessExecutor {
    fun executeProcess(idProcess: Int,user:String,password:String)
}
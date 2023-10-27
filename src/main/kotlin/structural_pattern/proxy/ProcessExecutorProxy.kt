package structural_pattern.proxy

class ProcessExecutorProxy : IProcessExecutor{
    override fun executeProcess(idProcess: Int, user: String, password: String) {
        //--Pre execute
        val securityService = SecurityService()
        if(!securityService.authorization(user,password)){
            throw Exception ("The user $user not have privileges for excute process")
        }
        //--- Process
        val executorProcess = DefaultProcessExecutor()
        executorProcess.executeProcess(idProcess,user,password)
        //--- Post execute
        val audit = AuditService()
        audit.auditServiceUsed(user,DefaultProcessExecutor::class.java.name)
    }
}
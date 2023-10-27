package structural_pattern.proxy


class SecurityService {
    fun authorization(user:String, password:String): Boolean{
        return if (user == "tonyuchiha" && password =="t0pSecr3et") {
            println("usuario $user autorizado")
            true
        }else{
            println("usuario $user No autorizado"  )
            false

        }
      //  return ((user.equals("tonyuchiha")&&(password =="t0pSecr3et")))
    }
}
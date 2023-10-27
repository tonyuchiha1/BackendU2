package structural_pattern.adapter

suspend fun main() {

    val request = BankCreditRequest("Antonio Jimenez", 1000.00)
    val xBank: IBankAdapter = XBankCreditAdapter()
    val xBankResponse = xBank.sendCreditRequest(request)
    println(
        """
        ${"xBank approved > " + xBankResponse.approved} 
        """.trimIndent()
    )

    val yBank: IBankAdapter = YBankCreditAdaptee()
    val yBankResponse = yBank.sendCreditRequest(request)
    println(
        """
        ${"yBank approved > " + yBankResponse.approved}
        """.trimIndent()
    )


    if (xBankResponse.approved) {
        println("xBank aprobó su crédito, felicidades!!")
    } else if (yBankResponse.approved) {
        println("yBank aprobó su crédito, felicidades!!")
    } else {
        println("lo sentimos su crédito no ha sido aprobado")
    }
}
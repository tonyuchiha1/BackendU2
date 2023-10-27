package structural_pattern.adapter

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class YBankCreditAdaptee : IBankAdapter, YBankCreditSenderListener {
    private var yResponse: YBankCreditResponse? = null
    override suspend fun sendCreditRequest(bankCreditRequest:  BankCreditRequest): BankCreditResponse {
        val yBankRequest = YBankCreditRequest(bankCreditRequest.customer, bankCreditRequest.amount)
        val sender = YBankCreditSender()
        sender.sendCreditForValidate(yBankRequest, this)
        do {
            try {

                withContext(Dispatchers.IO) {
                    delay(10000)
                }
                println("YBank petición en espera....")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } while (yResponse == null)

        val response = BankCreditResponse()
        response.approved= yResponse!!.approved
        return response
    }

    override fun notifyCreditResult(result: YBankCreditResponse) {
        yResponse = result
    }
}
package structural_pattern.adapter

class XBankCreditAdapter : IBankAdapter {
    override suspend fun sendCreditRequest(bankCreditRequest: BankCreditRequest): BankCreditResponse {
        val xRequest= XBankCreditRequest(bankCreditRequest.customer,bankCreditRequest.amount)
        val api= XBankCreditAPI()
        val bankCreditResponse = BankCreditResponse()
        bankCreditResponse.approved = api.sendCreditRequest(xRequest).approved
        return (bankCreditResponse)
    }
}
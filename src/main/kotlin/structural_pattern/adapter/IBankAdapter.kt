package structural_pattern.adapter

interface IBankAdapter {
    suspend fun sendCreditRequest(
        bankCreditRequest: BankCreditRequest
    ) : BankCreditResponse
}
package structural_pattern.adapter

class XBankCreditAPI {
    fun sendCreditRequest(request: XBankCreditRequest ): XBankCreditResponse{
        val response = XBankCreditResponse()
        response.approved = request.amount <=5000
        return response
        }
}
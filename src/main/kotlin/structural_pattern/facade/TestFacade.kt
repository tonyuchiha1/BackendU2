package structural_pattern.facade


fun main() {
    val request = PaymentRequest(amount = 500.0,
        cardExpireDate = "10/2015",
        cardName = "Oscar",
        cardNumber = "1234567890123456",
        cardSecureNumber = "345",
        customerId = 1L)

    try {
        val paymentFacade: IPaymentFacade = OnlinePaymentFacadeImpl()
        paymentFacade.pay(request)
    } catch (e: Exception) {
        println(e.message)
    }
}
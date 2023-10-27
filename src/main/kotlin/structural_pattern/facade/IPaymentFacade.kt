package structural_pattern.facade

interface IPaymentFacade {
    fun pay(paymentRequest: PaymentRequest): PaymentResponse
}
package structural_pattern.facade

data class PaymentResponse(
    val paymentConfirmNumber : String,
    val newBalance : Double,
    val customerStatus : String
)
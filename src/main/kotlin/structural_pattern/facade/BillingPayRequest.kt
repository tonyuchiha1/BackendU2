package structural_pattern.facade

data class BillingPayRequest(
    val customerId: Long,
    val amount: Double
)
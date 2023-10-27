package structural_pattern.facade

data class Customer(
    var customerId: Long,
    var fullName: String,
    var balance: Double,
    var status: String,
)
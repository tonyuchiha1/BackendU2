package structural_pattern.facade

data class TransferRequest(
    var amount : Double,
    var cardNumber : String,
    var cardName :String,
    var cardExpireData : String,
    var cardSecureNumber : String

)
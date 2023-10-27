package structural_pattern.facade

data class GeneralPaymentError(override val message : String): Exception (message)
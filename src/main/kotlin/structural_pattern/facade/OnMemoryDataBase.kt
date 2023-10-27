
package structural_pattern.facade


object OnMemoryDataBase {
    private val CUSTOMER_MAP: HashMap<Long, Customer> = HashMap<Long, Customer>()
    private val CARD_BINS = HashMap<String, Card>()

    init {
        CUSTOMER_MAP[1L] = Customer(1L, "Oscar Blancarte", 500.0, "Suspendido")
        CUSTOMER_MAP[2L] = Customer(2L, "Juan Pérez", 300.0, "Suspendido")
        CUSTOMER_MAP[3L] = Customer(3L, "Adrián López", 100.0, "Activo")
        CUSTOMER_MAP[4L] = Customer(4L, "Melisa Mares", 100.0, "Baja")
        CARD_BINS["123"] = Card("123", "VISA", CardType.CREDIT)
        CARD_BINS["234"] = Card("234", "MASTERCARD", CardType.DEBIT)
        CARD_BINS["345"] = Card("345", "AMEX", CardType.CREDIT)
    }

    fun findCustomerById(id: Long): Customer? {
        return CUSTOMER_MAP[id]
    }

    fun changeCustomerStatus(id: Long, newStatus: String) {
        val customer: Customer? = findCustomerById(id)
        customer!!.status = newStatus
        println(
            ("Cambio de status del cliente '" + customer.fullName
                    ) + "'" + newStatus
        )
    }

    fun validateCardBins(creditCardPrefix: String): Boolean {
        if (CARD_BINS.containsKey(creditCardPrefix)) {
            val company = CARD_BINS[creditCardPrefix]!!.company
            println(
                ("Tarjeta válida > '" + creditCardPrefix + "', "
                        + company + "\n")
            )
            return true
        } else {
            println("Tarjeta inválida >\n")
            return false
        }
    }

    fun getCardCompany(creditCardPrefix: String): String {
        if (CARD_BINS.containsKey(creditCardPrefix)) {
            return CARD_BINS[creditCardPrefix]!!.company
        }
        throw RuntimeException("Tarjeta no existe")
    }
}
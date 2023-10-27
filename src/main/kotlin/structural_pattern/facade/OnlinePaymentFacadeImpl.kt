package structural_pattern.facade

import structural_pattern.facade.OnMemoryDataBase.changeCustomerStatus


class OnlinePaymentFacadeImpl : IPaymentFacade {

    override fun pay(paymentRequest: PaymentRequest): PaymentResponse {
        val customer: Customer = crmSystem.findCustomer(paymentRequest.customerId)
            ?: throw GeneralPaymentError("El cliente no esta en la BD")
        if ("Baja" == customer.status) {
            throw GeneralPaymentError(
                "El cliente con id '"
                        + paymentRequest.customerId + "' está dado de baja."
            )
        } else if (paymentRequest.amount >
            billingSystem.queryCustomerBalance(customer.customerId)
        ) {
            throw GeneralPaymentError(
                ("Se está intentado realizar un pago "
                        + "\n\tmayor al saldo del cliente")
            )
        }
        val transfer = TransferRequest(
            paymentRequest.amount, paymentRequest.cardNumber,
            paymentRequest.cardName, paymentRequest.cardExpireDate,
            paymentRequest.cardNumber
        )
        val payReference: String = bankSystem.transfer(transfer)
        val billingRequest = BillingPayRequest(
            paymentRequest.customerId, paymentRequest.amount
        )
        val newBalance: Double = billingSystem.pay(billingRequest)

        //--- El cliente se reactiva si el nuevo saldo es menor de 51$
        var newStatus = customer.status
        if (newBalance <= 50) {
            changeCustomerStatus(paymentRequest.customerId, "Activo")
            newStatus = "Activo"
        }
        //--- Envío de la confirmación de pago por Email.
        val params = HashMap<String, String>()
        params["\$name"] = customer.fullName
        params["\$ammount"] = paymentRequest.amount.toString() + ""
        params["\$newBalance"] = newBalance.toString() + ""
        val number = paymentRequest.cardNumber
        val subfix = number.substring(number.length - 4, number.length)
        params["\$cardNumber"] = subfix
        params["\$reference"] = payReference
        params["\$newStatus"] = newStatus
        emailSenderSystem.sendEmail(params)
        return PaymentResponse(payReference, newBalance, newStatus)
    }

    companion object {
        private val crmSystem: CRMSystem = CRMSystem()
        private val billingSystem: BillingSystem = BillingSystem()
        private val bankSystem: BankSystem = BankSystem()
        private val emailSenderSystem: EmailSystem = EmailSystem()
    }
}
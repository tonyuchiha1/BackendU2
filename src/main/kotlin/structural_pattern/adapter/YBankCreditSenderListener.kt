package structural_pattern.adapter

interface YBankCreditSenderListener {
    fun notifyCreditResult(result: YBankCreditResponse)
}

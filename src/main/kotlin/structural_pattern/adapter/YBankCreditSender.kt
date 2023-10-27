package structural_pattern.adapter

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class YBankCreditSender {
        suspend fun sendCreditForValidate(request: YBankCreditRequest, listener: YBankCreditSenderListener) {
            runBlocking {
                launch {
                    println("YBank recibió la solicitud en un momento y tendrá la respuesta, sea paciente por favor")
                    val response = YBankCreditResponse()
                    response.approved = request.credit <= 1500
                    delay(1000 * 30) // Delay for 30 seconds
                    listener.notifyCreditResult(response)
                }
            }
        }
    }
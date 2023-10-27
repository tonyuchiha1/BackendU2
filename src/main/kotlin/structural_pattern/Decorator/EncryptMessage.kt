package structural_pattern.Decorator

import java.security.Key
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class EncryptMessage(private val user: String,
                     private val password: String,
                     message: IMessage) : MessageDecorator(
    message
) {
    override fun processMessage(): IMessage {
        message = message.processMessage()
        message = encryptMessage()
        return message
    }

    private fun encryptMessage(): IMessage {
        return try {
            val key: Key = SecretKeySpec(password.toByteArray(), "AES")
            val c = Cipher.getInstance("AES")
            c.init(Cipher.ENCRYPT_MODE, key)
            val encVal = c.doFinal(message.content.toByteArray())
            val encryptedValue: String = Base64.getEncoder().encodeToString(encVal)
            message.content = encryptedValue
            message
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException()
        }
    }
}



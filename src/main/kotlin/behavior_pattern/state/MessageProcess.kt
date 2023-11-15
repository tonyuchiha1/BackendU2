package behavior_pattern.state
import java.util.*

class MessageProcess(private val server: Server) {

    private var sendThread: Thread? = null
    private val messageQueue: Queue<String> = LinkedList()

    // Método para encolar un mensaje en la cola.
    fun queueMessage(message: String): Boolean {
        // Verifica si la cola de mensajes ha alcanzado el límite establecido por el servidor.
        if (messageQueue.size >= server.getMaxRequest()) {
            println("Requests reached maximum (${messageQueue.size})")
            return false
        }
        // Agrega el mensaje a la cola.
        messageQueue.add(message)
        println("Queue message (${messageQueue.size})")
        return true
    }

    // Método para obtener el número de mensajes en la cola.
    fun countMessage(): Int {
        return messageQueue.size
    }

    // Método para iniciar el procesamiento de mensajes en un hilo separado.
    fun start() {
        sendThread = Thread {
            try {
                // Bucle de procesamiento que duerme durante 10 segundos y procesa mensajes si la cola no está vacía.
                while (true) {
                    Thread.sleep(1000 * 10)
                    if (messageQueue.isNotEmpty()) {
                        val message = messageQueue.poll()
                        println("Message process > $message(${messageQueue.size})")
                    }
                }
            } catch (ex: InterruptedException) {
                println(ex.message)
            }
        }

        // Inicia el hilo de procesamiento.
        sendThread?.start()
    }

    // Método para detener el hilo de procesamiento.
    fun stop() {
        sendThread?.interrupt()
        sendThread = null
    }
}

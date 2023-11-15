package behavior_pattern.state
import behavior_pattern.patronstatepackage.StopServerState
import java.awt.event.ActionEvent
import java.io.OutputStream
import java.io.PrintStream
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JTextArea

class ServerPanel : JPanel() {
    private var server: Server? = null
    private var messageCounter = 0
    private var jTextArea1: JTextArea? = null

    // Constructor principal donde se inicializan los componentes y se configura el servidor.
    init {
        initComponents()

        // Configuración para redirigir la salida estándar al JTextArea.
        val defaultPrinter: PrintStream = System.out
        val interceptor = TextAreaPrinter(defaultPrinter)
        System.setOut(interceptor)

        // Inicialización del servidor.
        server = Server()
    }

    // Clase interna que redirige la salida estándar al JTextArea.
    private inner class TextAreaPrinter(out: OutputStream) : PrintStream(out, true) {
        override fun print(line: String) {
            println(line)
        }

        override fun println(line: String) {
            val formattedLine = "$line\n"
            super.print(formattedLine)
            jTextArea1?.append(formattedLine)
            jTextArea1?.caretPosition = jTextArea1?.document?.length ?: 0
        }
    }

    // Inicialización de los componentes de la GUI.
    private fun initComponents() {
        jTextArea1 = JTextArea()
        add(jTextArea1)

        // Agregar botones y manejar eventos aquí.
        val startButton = JButton("Start/Stop Server")
        startButton.addActionListener { startAction(it) }
        add(startButton)

        val sendMessageButton = JButton("Send Message")
        sendMessageButton.addActionListener { sendMessageEvent(it) }
        add(sendMessageButton)
    }

    // Manejo del evento de enviar mensaje al servidor.
    private fun sendMessageEvent(evt: ActionEvent) {
        server?.handleMessage("Send Message + ${++messageCounter}")
    }

    // Manejo del evento de inicio/detención del servidor.
    private fun startAction(evt: ActionEvent) {
        // Obtiene el estado actual del servidor.
        val state = server?.getState()

        // Realiza acciones en función del estado actual.
        when (state) {
            is StopServerState -> {
                jTextArea1?.text = "Stop"
                server?.changeStateTo(StartingServerState(server!!))
            }
            is StartingServerState -> {
                server?.changeStateTo(StopServerState(server!!))
            }
            else -> {
                jTextArea1?.text = "Start"
                server?.changeStateTo(StopServerState(server!!))
            }
        }
    }
}

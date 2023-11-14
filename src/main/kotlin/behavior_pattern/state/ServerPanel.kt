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

    init {
        initComponents()

        val defaultPrinter: PrintStream = System.out
        val interceptor = TextAreaPrinter(defaultPrinter)
        System.setOut(interceptor)

        server = Server()
    }

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

    private fun initComponents() {
        jTextArea1 = JTextArea()
        add(jTextArea1)

        // Agregar botones y manejar eventos aquí
        val startButton = JButton("Start/Stop Server")
        startButton.addActionListener { startAction(it) }
        add(startButton)

        val sendMessageButton = JButton("Send Message")
        sendMessageButton.addActionListener { sendMessageEvent(it) }
        add(sendMessageButton)
    }

    private fun sendMessageEvent(evt: ActionEvent) {
        server?.handleMessage("Send Message + ${++messageCounter}")
    }

    private fun startAction(evt: ActionEvent) {
        val state = server?.getState()
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

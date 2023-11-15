package behavior_pattern.state
import javax.swing.JFrame

object StateMain {

    @JvmStatic
    fun main(args: Array<String>) {
        // Crea una instancia de JFrame.
        val frame = JFrame()

        // Configura el título de la ventana.
        frame.title = "State pattern"

        // Establece la operación predeterminada al cerrar la ventana.
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        // Agrega un panel de servidor (ServerPanel) a la ventana.
        frame.add(ServerPanel())

        // Empaqueta los componentes en la ventana.
        frame.pack()

        // Hace visible la ventana.
        frame.isVisible = true
    }
}


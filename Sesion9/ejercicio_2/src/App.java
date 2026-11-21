import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        VistaCompraPasaje vista = new VistaCompraPasaje();
        new ControladorPasaje(vista);

        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setSize(620,420);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }
}

/*
 * COMENTARIO TEÓRICO (Laboratorio 09 - Swing y Contenedores):
 * Esta clase actúa como punto de entrada (main) de la aplicación y gestiona el ciclo
 * de vida del contenedor de nivel superior JFrame. Según la teoría de Swing, un JFrame
 * es una ventana pesada del sistema operativo que aloja componentes ligeros (JComponent).
 * Aquí se inicializa la arquitectura MVC instanciando la Vista (VistaCompraPasaje) y
 * vinculándola con su Controlador (ControladorPasaje). Además, se configuran las
 * propiedades esenciales del marco mediante métodos clave de Window y Frame:
 * setDefaultCloseOperation(EXIT_ON_CLOSE) para liberar recursos y terminar el proceso,
 * setSize(620,420) para delimitar las dimensiones iniciales, setLocationRelativeTo(null)
 * para centrar la ventana en la pantalla del usuario, y setVisible(true) para transferir
 * el control visual al hilo de despacho de eventos de Java (Event Dispatch Thread).
 */

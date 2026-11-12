import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorPasaje implements ActionListener{
    private final VistaCompraPasaje vista;

    public ControladorPasaje(VistaCompraPasaje vista)
    {
        this.vista = vista;
        this.vista.getBtnResumen().addActionListener(this);
        this.vista.getBtnReiniciar().addActionListener(this);
    }

    @Override 
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == vista.getBtnResumen()) { procesarResumen();}
        else if (e.getSource() == vista.getBtnReiniciar()) {vista.limpiarFormulario();}

    }

    private void procesarResumen(){
        String nombres = vista.getNombres();
        String documento = vista.getDocumento();
        String fechaDeSalida = vista.getFechaDeSalida();

        if (nombres.isEmpty() || documento.isEmpty() || fechaDeSalida.isEmpty())
        {
            vista.mostrarMensaje("Completa todos los datos del pasajero.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Pasaje modelo = new Pasaje(
            nombres, 
            documento, 
            vista.getOrigen(),
            vista.getDestino(),
            fechaDeSalida,
            vista.getServiciosSeleccionados(),
            vista.getPiso(),
            vista.getCalidad()
        );

        vista.mostrarMensaje(modelo.toString(),"Resumen de Pasaje", JOptionPane.INFORMATION_MESSAGE);
    }

}

/*
 * COMENTARIO TEÓRICO (Laboratorio 09 - Modelo de Eventos por Delegación):
 * Esta clase implementa el Controlador en MVC y materializa el modelo de eventos por
 * delegación de Java AWT/Swing. Al implementar la interfaz de escucha ActionListener, actúa
 * como componente de escucha para los eventos de acción originados por los botones JButton
 * de la vista (btnResumen y btnReiniciar), los cuales se registran mediante el método
 * addActionListener(). Al producirse la interacción del usuario, la JVM despacha un objeto
 * ActionEvent invocando al método manejador actionPerformed(ActionEvent e). Mediante el
 * método e.getSource() se identifica qué botón disparó el evento, ejecutando la lógica
 * correspondiente: limpiar el formulario o validar los datos de la interfaz, instanciar
 * el objeto de negocio Pasaje y delegar la presentación del resumen resultante a través
 * de un cuadro de diálogo informativo de JOptionPane.
 */

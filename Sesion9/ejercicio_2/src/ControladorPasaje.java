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


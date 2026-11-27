package ej3;

import ej3.command.InvocadorPedidos;
import ej3.controlador.ControladorPedidos;
import ej3.modelo.GestorPedidos;
import ej3.vista.VentanaPedidos;
import javax.swing.SwingUtilities;

/**
 * Punto de entrada de la aplicación Swing de gestión de pedidos.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestorPedidos gestor = new GestorPedidos();
            InvocadorPedidos invocador = new InvocadorPedidos();
            VentanaPedidos vista = new VentanaPedidos();
            new ControladorPedidos(gestor, invocador, vista);
            vista.setVisible(true);
        });
    }
}

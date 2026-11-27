package ej3.controlador;

import ej3.command.CompletarPedidoCommand;
import ej3.command.InvocadorPedidos;
import ej3.command.RegistrarPedidoCommand;
import ej3.modelo.GestorPedidos;
import ej3.strategy.EstrategiaPedido;
import ej3.vista.VentanaPedidos;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Controlador que conecta el modelo, el invocador de comandos y la vista Swing.
 */
public class ControladorPedidos {
    private final GestorPedidos gestor;
    private final InvocadorPedidos invocador;
    private final VentanaPedidos vista;

    public ControladorPedidos(GestorPedidos gestor, InvocadorPedidos invocador, VentanaPedidos vista) {
        this.gestor = gestor;
        this.invocador = invocador;
        this.vista = vista;

        this.gestor.agregarObservador(this.vista.getPanelTabla());
        this.gestor.agregarObservador(this.vista.getPanelResumen());

        configurarEventos();
        actualizarVistaPrevia();
        actualizarEstadoDeshacer();
    }

    private void configurarEventos() {
        vista.getBtnRegistrar().addActionListener(e -> registrarPedido());
        vista.getBtnCompletar().addActionListener(e -> completarPedidoSeleccionado());
        vista.getBtnDeshacer().addActionListener(e -> deshacerUltimo());
        vista.getCmbEstrategia().addActionListener(e -> actualizarVistaPrevia());

        vista.getTxtMontoBase().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }
        });
    }

    private void actualizarVistaPrevia() {
        EstrategiaPedido estrategia = (EstrategiaPedido) vista.getCmbEstrategia().getSelectedItem();
        if (estrategia == null) {
            vista.getLblDescripcionEstrategia().setText("-");
            vista.getLblCostoEstimado().setText("S/ --");
            return;
        }

        vista.getLblDescripcionEstrategia().setText(estrategia.getDescripcion());
        String textoMonto = vista.getTxtMontoBase().getText().trim();
        if (textoMonto.isEmpty()) {
            vista.getLblCostoEstimado().setText("S/ --");
            return;
        }

        try {
            double monto = Double.parseDouble(textoMonto);
            if (monto > 0 && !Double.isNaN(monto) && !Double.isInfinite(monto)) {
                double estimado = estrategia.calcularCostoFinal(monto);
                vista.getLblCostoEstimado().setText(String.format("S/ %.2f", estimado));
            } else {
                vista.getLblCostoEstimado().setText("S/ --");
            }
        } catch (NumberFormatException ex) {
            vista.getLblCostoEstimado().setText("S/ --");
        }
    }

    private void registrarPedido() {
        String cliente = vista.getTxtCliente().getText();
        String detalle = vista.getTxtDetalle().getText();
        String textoMonto = vista.getTxtMontoBase().getText().trim();
        EstrategiaPedido estrategia = (EstrategiaPedido) vista.getCmbEstrategia().getSelectedItem();

        double montoBase;
        try {
            montoBase = Double.parseDouble(textoMonto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    vista,
                    "Ingrese un monto base numérico válido.",
                    "Datos inválidos",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            RegistrarPedidoCommand comando = new RegistrarPedidoCommand(
                    gestor, cliente, detalle, montoBase, estrategia);
            invocador.ejecutarComando(comando);
            vista.limpiarFormulario();
            actualizarEstadoDeshacer();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                    vista,
                    ex.getMessage(),
                    "Datos inválidos",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void completarPedidoSeleccionado() {
        Integer idSeleccionado = vista.getPanelTabla().getPedidoIdSeleccionado();
        if (idSeleccionado == null) {
            JOptionPane.showMessageDialog(
                    vista,
                    "Seleccione un pedido de la tabla para completar.",
                    "Sin selección",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        CompletarPedidoCommand comando = new CompletarPedidoCommand(gestor, idSeleccionado);
        if (!invocador.ejecutarComando(comando)) {
            JOptionPane.showMessageDialog(
                    vista,
                    "El pedido seleccionado ya se encuentra completado.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        actualizarEstadoDeshacer();
    }

    private void deshacerUltimo() {
        invocador.deshacerUltimo();
        actualizarEstadoDeshacer();
    }

    private void actualizarEstadoDeshacer() {
        vista.getBtnDeshacer().setEnabled(invocador.puedeDeshacer());
    }
}

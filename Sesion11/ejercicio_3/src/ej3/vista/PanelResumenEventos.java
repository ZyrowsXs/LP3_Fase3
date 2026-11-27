package ej3.vista;

import ej3.modelo.EstadoPedido;
import ej3.modelo.Pedido;
import ej3.observer.ObservadorPedido;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Panel de resumen estadístico y bitácora de eventos del sistema.
 */
public class PanelResumenEventos extends JPanel implements ObservadorPedido {
    private final JLabel lblTotal = new JLabel("Total: 0");
    private final JLabel lblPendientes = new JLabel("Pendientes: 0");
    private final JLabel lblCompletados = new JLabel("Completados: 0");
    private final JLabel lblRecaudado = new JLabel("Recaudado: S/ 0.00");
    private final JTextArea txtEventos = new JTextArea(5, 40);

    public PanelResumenEventos() {
        setLayout(new BorderLayout(8, 8));
        setBorder(BorderFactory.createTitledBorder("Resumen y Eventos"));

        JPanel panelIndicadores = new JPanel(new GridLayout(1, 4, 12, 0));
        panelIndicadores.add(lblTotal);
        panelIndicadores.add(lblPendientes);
        panelIndicadores.add(lblCompletados);
        panelIndicadores.add(lblRecaudado);

        txtEventos.setEditable(false);
        txtEventos.setLineWrap(true);
        txtEventos.setWrapStyleWord(true);

        add(panelIndicadores, BorderLayout.NORTH);
        add(new JScrollPane(txtEventos), BorderLayout.CENTER);
    }

    @Override
    public void actualizar(String evento, List<Pedido> pedidos) {
        int total = pedidos.size();
        int pendientes = 0;
        int completados = 0;
        double recaudado = 0.0;

        for (Pedido p : pedidos) {
            if (p.getEstado() == EstadoPedido.COMPLETADO) {
                completados++;
                recaudado += p.getCostoFinal();
            } else {
                pendientes++;
            }
        }

        lblTotal.setText("Total: " + total);
        lblPendientes.setText("Pendientes: " + pendientes);
        lblCompletados.setText("Completados: " + completados);
        lblRecaudado.setText(String.format("Recaudado: S/ %.2f", recaudado));

        if (evento != null && !evento.isBlank()) {
            txtEventos.append("- " + evento + "\n");
            txtEventos.setCaretPosition(txtEventos.getDocument().getLength());
        }
    }
}

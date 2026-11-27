package ej3.vista;

import ej3.modelo.Pedido;
import ej3.observer.ObservadorPedido;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * Panel con tabla de pedidos que se actualiza automáticamente como observador.
 */
public class PanelTablaPedidos extends JPanel implements ObservadorPedido {
    private static final String[] COLUMNAS = {
        "ID", "Cliente", "Detalle", "Estrategia", "Costo Final", "Estado"
    };

    private final DefaultTableModel modeloTabla;
    private final JTable tabla;

    public PanelTablaPedidos() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Pedidos Registrados"));

        modeloTabla = new DefaultTableModel(COLUMNAS, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla = new JTable(modeloTabla);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setReorderingAllowed(false);

        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }

    @Override
    public void actualizar(String evento, List<Pedido> pedidos) {
        modeloTabla.setRowCount(0);
        for (Pedido p : pedidos) {
            modeloTabla.addRow(new Object[] {
                p.getId(),
                p.getCliente(),
                p.getDetalle(),
                p.getEstrategia().getNombre(),
                String.format("S/ %.2f", p.getCostoFinal()),
                p.getEstado().name()
            });
        }
    }

    public Integer getPedidoIdSeleccionado() {
        int fila = tabla.getSelectedRow();
        if (fila < 0) {
            return null;
        }
        return (Integer) modeloTabla.getValueAt(fila, 0);
    }
}

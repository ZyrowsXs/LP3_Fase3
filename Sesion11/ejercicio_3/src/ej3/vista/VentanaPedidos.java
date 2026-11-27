package ej3.vista;

import ej3.strategy.EstrategiaEconomica;
import ej3.strategy.EstrategiaPedido;
import ej3.strategy.EstrategiaRapida;
import ej3.strategy.EstrategiaVIP;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Ventana principal de la aplicación de gestión de pedidos.
 */
public class VentanaPedidos extends JFrame {
    private final JTextField txtCliente = new JTextField(18);
    private final JTextField txtDetalle = new JTextField(18);
    private final JTextField txtMontoBase = new JTextField(10);
    private final JComboBox<EstrategiaPedido> cmbEstrategia = new JComboBox<>(new EstrategiaPedido[] {
        new EstrategiaEconomica(),
        new EstrategiaRapida(),
        new EstrategiaVIP()
    });
    private final JLabel lblDescripcionEstrategia = new JLabel("-");
    private final JLabel lblCostoEstimado = new JLabel("S/ --");
    private final JButton btnRegistrar = new JButton("Registrar Pedido");

    private final PanelTablaPedidos panelTabla = new PanelTablaPedidos();
    private final JButton btnCompletar = new JButton("Completar Seleccionado");
    private final JButton btnDeshacer = new JButton("Deshacer");
    private final PanelResumenEventos panelResumen = new PanelResumenEventos();

    public VentanaPedidos() {
        super("Gestión de Pedidos - MVC / Observer / Strategy / Command");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contenedor = new JPanel(new BorderLayout(10, 10));
        contenedor.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        contenedor.add(crearPanelFormulario(), BorderLayout.NORTH);
        contenedor.add(panelTabla, BorderLayout.CENTER);
        contenedor.add(crearPanelInferior(), BorderLayout.SOUTH);

        setContentPane(contenedor);
        setSize(860, 620);
        setLocationRelativeTo(null);
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Nuevo Pedido"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 6, 4, 6);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        panel.add(new JLabel("Cliente:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        panel.add(txtCliente, gbc);

        gbc.gridx = 2; gbc.weightx = 0;
        panel.add(new JLabel("Detalle:"), gbc);
        gbc.gridx = 3; gbc.weightx = 1.0;
        panel.add(txtDetalle, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        panel.add(new JLabel("Monto base (S/):"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        panel.add(txtMontoBase, gbc);

        gbc.gridx = 2; gbc.weightx = 0;
        panel.add(new JLabel("Estrategia:"), gbc);
        gbc.gridx = 3; gbc.weightx = 1.0;
        panel.add(cmbEstrategia, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        panel.add(new JLabel("Descripción:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2; gbc.weightx = 1.0;
        panel.add(lblDescripcionEstrategia, gbc);
        gbc.gridwidth = 1;

        JPanel panelDerecha = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        panelDerecha.add(new JLabel("Costo estimado:"));
        panelDerecha.add(lblCostoEstimado);
        panelDerecha.add(btnRegistrar);
        gbc.gridx = 3; gbc.weightx = 0;
        panel.add(panelDerecha, gbc);

        return panel;
    }

    private JPanel crearPanelInferior() {
        JPanel panel = new JPanel(new BorderLayout(8, 8));

        JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        panelAcciones.add(btnCompletar);
        panelAcciones.add(btnDeshacer);

        panel.add(panelAcciones, BorderLayout.NORTH);
        panel.add(panelResumen, BorderLayout.CENTER);
        return panel;
    }

    public void limpiarFormulario() {
        txtCliente.setText("");
        txtDetalle.setText("");
        txtMontoBase.setText("");
        txtCliente.requestFocusInWindow();
    }

    public JTextField getTxtCliente() {
        return txtCliente;
    }

    public JTextField getTxtDetalle() {
        return txtDetalle;
    }

    public JTextField getTxtMontoBase() {
        return txtMontoBase;
    }

    public JComboBox<EstrategiaPedido> getCmbEstrategia() {
        return cmbEstrategia;
    }

    public JLabel getLblDescripcionEstrategia() {
        return lblDescripcionEstrategia;
    }

    public JLabel getLblCostoEstimado() {
        return lblCostoEstimado;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JButton getBtnCompletar() {
        return btnCompletar;
    }

    public JButton getBtnDeshacer() {
        return btnDeshacer;
    }

    public PanelTablaPedidos getPanelTabla() {
        return panelTabla;
    }

    public PanelResumenEventos getPanelResumen() {
        return panelResumen;
    }
}

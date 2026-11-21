import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Vista Swing para visualizar y actualizar un Producto.
 */
public class ProductoView extends JFrame {
    private final JTextField nombreField;
    private final JTextField precioField;
    private final JTextField cantidadStockField;
    private final JTextField categoriaField;
    private final JButton actualizarButton;
    private final JLabel resumenLabel;

    /**
     * Construye e inicializa los componentes graficos de la ventana.
     */
    public ProductoView() {
        super("Gestión de Producto - MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel rootPanel = new JPanel(new BorderLayout(12, 12));
        rootPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        nombreField = new JTextField(20);
        precioField = new JTextField(20);
        cantidadStockField = new JTextField(20);
        categoriaField = new JTextField(20);

        addFormRow(formPanel, gbc, 0, "Nombre del producto:", nombreField);
        addFormRow(formPanel, gbc, 1, "Precio:", precioField);
        addFormRow(formPanel, gbc, 2, "Cantidad en stock:", cantidadStockField);
        addFormRow(formPanel, gbc, 3, "Categoría:", categoriaField);

        actualizarButton = new JButton("Actualizar Producto");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 4));
        buttonPanel.add(actualizarButton);

        resumenLabel = new JLabel("", SwingConstants.CENTER);
        resumenLabel.setFont(resumenLabel.getFont().deriveFont(Font.PLAIN, 13f));
        resumenLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Información del Producto"),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));

        rootPanel.add(formPanel, BorderLayout.NORTH);
        rootPanel.add(buttonPanel, BorderLayout.CENTER);
        rootPanel.add(resumenLabel, BorderLayout.SOUTH);

        setContentPane(rootPanel);
        pack();
        Dimension initialSize = new Dimension(Math.max(getWidth(), 560), getHeight());
        setSize(initialSize);
        setMinimumSize(initialSize);
        setLocationRelativeTo(null);
    }

    private void addFormRow(JPanel panel, GridBagConstraints gbc, int row, String labelText, JTextField field) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel(labelText), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        panel.add(field, gbc);
    }

    public String getNombreInput() {
        return nombreField.getText().trim();
    }

    public String getPrecioInput() {
        return precioField.getText().trim();
    }

    public String getCantidadStockInput() {
        return cantidadStockField.getText().trim();
    }

    public String getCategoriaInput() {
        return categoriaField.getText().trim();
    }

    public void setCampos(String nombre, String precio, String stock, String categoria) {
        nombreField.setText(nombre);
        precioField.setText(precio);
        cantidadStockField.setText(stock);
        categoriaField.setText(categoria);
    }

    public void setResumenProducto(String resumen) {
        resumenLabel.setText(resumen);
        Dimension preferred = getPreferredSize();
        if (getWidth() < preferred.width || getHeight() < preferred.height) {
            Dimension adjusted = new Dimension(
                    Math.max(getWidth(), preferred.width),
                    Math.max(getHeight(), preferred.height)
            );
            setSize(adjusted);
            setMinimumSize(adjusted);
        }
        revalidate();
        repaint();
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error de validación", JOptionPane.ERROR_MESSAGE);
    }

    public void addActualizarListener(ActionListener listener) {
        actualizarButton.addActionListener(listener);
    }
}

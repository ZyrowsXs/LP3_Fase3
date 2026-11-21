import javax.swing.*;
import java.awt.*;

public class AppBindingVehiculo extends JFrame {
    private JTextField txtPlaca;
    private JTextField txtMarca;
    private JTextField txtAnio;
    private JTextField txtKilometraje;
    private JLabel lblEstado;
    private Vehiculo vehiculo;

    public AppBindingVehiculo() {
        super("Binding de Datos - Gestión de Vehículo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 320);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        vehiculo = new Vehiculo("ABC-123", "Toyota", 2022, 18500);

        JPanel panelCampos = new JPanel(new GridLayout(4, 2, 8, 8));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));

        txtPlaca = new JTextField(vehiculo.getPlaca());
        txtMarca = new JTextField(vehiculo.getMarca());
        txtAnio = new JTextField(String.valueOf(vehiculo.getAnio()));
        txtKilometraje = new JTextField(String.valueOf(vehiculo.getKilometraje()));

        panelCampos.add(new JLabel("Placa:"));
        panelCampos.add(txtPlaca);
        panelCampos.add(new JLabel("Marca:"));
        panelCampos.add(txtMarca);
        panelCampos.add(new JLabel("Año:"));
        panelCampos.add(txtAnio);
        panelCampos.add(new JLabel("Kilometraje (km):"));
        panelCampos.add(txtKilometraje);

        JButton btnActualizar = new JButton("Actualizar Vehículo");
        JButton btnRestaurar = new JButton("Restaurar Vista");

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 8));
        panelBotones.add(btnActualizar);
        panelBotones.add(btnRestaurar);

        lblEstado = new JLabel("", SwingConstants.CENTER);
        lblEstado.setBorder(BorderFactory.createTitledBorder("Vehículo Registrado"));
        actualizarEtiqueta();

        btnActualizar.addActionListener(e -> {
            String placa = txtPlaca.getText().trim();
            String marca = txtMarca.getText().trim();
            if (placa.isEmpty() || marca.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La placa y la marca son obligatorias.");
                return;
            }
            try {
                int anio = Integer.parseInt(txtAnio.getText().trim());
                int km = Integer.parseInt(txtKilometraje.getText().trim());
                if (anio < 1950 || anio > 2026 || km < 0) {
                    JOptionPane.showMessageDialog(this, "Ingrese un año válido (1950-2026) y kilometraje positivo.");
                    return;
                }
                vehiculo.setPlaca(placa);
                vehiculo.setMarca(marca);
                vehiculo.setAnio(anio);
                vehiculo.setKilometraje(km);
                actualizarEtiqueta();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Año y kilometraje deben ser números enteros.");
            }
        });

        btnRestaurar.addActionListener(e -> {
            txtPlaca.setText(vehiculo.getPlaca());
            txtMarca.setText(vehiculo.getMarca());
            txtAnio.setText(String.valueOf(vehiculo.getAnio()));
            txtKilometraje.setText(String.valueOf(vehiculo.getKilometraje()));
            actualizarEtiqueta();
        });

        add(panelCampos, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(lblEstado, BorderLayout.SOUTH);
    }

    private void actualizarEtiqueta() {
        lblEstado.setText(vehiculo.getMarca() + " [" + vehiculo.getPlaca() + "] - Año "
                + vehiculo.getAnio() + " - " + vehiculo.getKilometraje() + " km");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppBindingVehiculo().setVisible(true));
    }
}

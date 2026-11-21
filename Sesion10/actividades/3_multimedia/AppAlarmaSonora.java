import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AppAlarmaSonora extends JFrame {
    private JComboBox<Integer> cmbSegundos;
    private JComboBox<String> cmbTono;
    private JLabel lblCuenta;
    private Timer timer;
    private Clip clip;
    private int restantes;

    public AppAlarmaSonora() {
        super("Alarma Sonora con Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 220);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));

        JPanel panelConfig = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 10));
        cmbSegundos = new JComboBox<>(new Integer[]{3, 5, 10});
        cmbTono = new JComboBox<>(new String[]{"3_multimedia\\Ejemplo\\campana.wav", "3_multimedia\\Ejemplo\\riser.wav"});
        panelConfig.add(new JLabel("Segundos:"));
        panelConfig.add(cmbSegundos);
        panelConfig.add(new JLabel("Tono:"));
        panelConfig.add(cmbTono);

        lblCuenta = new JLabel("Listo para iniciar", SwingConstants.CENTER);
        lblCuenta.setFont(new Font("SansSerif", Font.BOLD, 16));

        JButton btnIniciar = new JButton("Iniciar Alarma");
        JButton btnSilenciar = new JButton("Silenciar");
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotones.add(btnIniciar);
        panelBotones.add(btnSilenciar);

        timer = new Timer(1000, e -> {
            restantes--;
            if (restantes > 0) {
                lblCuenta.setText("Tiempo restante: " + restantes + " s");
            } else {
                timer.stop();
                lblCuenta.setText("¡Tiempo cumplido!");
                reproducirTono((String) cmbTono.getSelectedItem());
            }
        });

        btnIniciar.addActionListener(e -> {
            detenerTono();
            restantes = (Integer) cmbSegundos.getSelectedItem();
            lblCuenta.setText("Tiempo restante: " + restantes + " s");
            timer.restart();
        });

        btnSilenciar.addActionListener(e -> {
            timer.stop();
            detenerTono();
            lblCuenta.setText("Alarma detenida");
        });

        add(panelConfig, BorderLayout.NORTH);
        add(lblCuenta, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void reproducirTono(String ruta) {
        try {
            File archivo = new File(ruta);
            if (!archivo.exists()) {
                JOptionPane.showMessageDialog(this, "No se encontró el archivo: " + ruta);
                return;
            }
            AudioInputStream stream = AudioSystem.getAudioInputStream(archivo);
            clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al reproducir sonido: " + ex.getMessage());
        }
    }

    private void detenerTono() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppAlarmaSonora().setVisible(true));
    }
}

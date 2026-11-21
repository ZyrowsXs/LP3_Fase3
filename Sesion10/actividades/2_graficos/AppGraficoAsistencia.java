import javax.swing.*;
import java.awt.*;

public class AppGraficoAsistencia extends JFrame {
    private String[] cursos = {"LP3", "REDES1", "FSI", "ECO", "FISICA"};
    private int[] asistencia = {92, 85, 78, 95, 88};

    private JComboBox<String> cmbCurso;
    private JTextField txtPorcentaje;
    private JPanel panelGrafico;

    public AppGraficoAsistencia() {
        super("Porcentaje de Asistencia por Curso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 420);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));

        panelGrafico = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int anchoBarra = 50;
                int espacio = 22;
                int margenIzq = 60;
                int margenInf = 50;
                int alturaMax = 200;

                for (int i = 0; i < cursos.length; i++) {
                    int alturaBarra = (int) ((double) asistencia[i] / 100.0 * alturaMax);
                    int x = margenIzq + i * (anchoBarra + espacio);
                    int y = getHeight() - margenInf - alturaBarra;

                    g2d.setColor(new Color(80, 140, 200));
                    g2d.fillRect(x, y, anchoBarra, alturaBarra);

                    g2d.setColor(Color.BLACK);
                    g2d.drawString(asistencia[i] + "%", x + 12, y - 5);
                    g2d.drawString(cursos[i], x + 14, getHeight() - margenInf + 20);
                }

                g2d.drawLine(margenIzq, getHeight() - margenInf,
                        margenIzq, getHeight() - margenInf - alturaMax);
                g2d.drawString("Asist. (%)", margenIzq - 52, getHeight() - margenInf - alturaMax - 10);
            }
        };

        JPanel panelControles = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));
        cmbCurso = new JComboBox<>(cursos);
        txtPorcentaje = new JTextField(String.valueOf(asistencia[0]), 5);
        JButton btnActualizar = new JButton("Actualizar");

        cmbCurso.addActionListener(e -> {
            int idx = cmbCurso.getSelectedIndex();
            txtPorcentaje.setText(String.valueOf(asistencia[idx]));
        });

        btnActualizar.addActionListener(e -> {
            int idx = cmbCurso.getSelectedIndex();
            try {
                int valor = Integer.parseInt(txtPorcentaje.getText().trim());
                if (valor < 0 || valor > 100) {
                    JOptionPane.showMessageDialog(this, "Ingrese un porcentaje entre 0 y 100.");
                    return;
                }
                asistencia[idx] = valor;
                panelGrafico.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número entero válido.");
            }
        });

        panelControles.add(new JLabel("Curso:"));
        panelControles.add(cmbCurso);
        panelControles.add(new JLabel("Asistencia (%):"));
        panelControles.add(txtPorcentaje);
        panelControles.add(btnActualizar);

        add(panelGrafico, BorderLayout.CENTER);
        add(panelControles, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppGraficoAsistencia().setVisible(true));
    }
}

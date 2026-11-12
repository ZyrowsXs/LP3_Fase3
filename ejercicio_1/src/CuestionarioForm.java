import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CuestionarioForm {
    private JPanel panelPrincipal;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JButton btnResumen;
    private JLabel lblResumen;

    public CuestionarioForm() {
        btnResumen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String edadTexto = txtEdad.getText();

                if (nombre.equals("") || edadTexto.equals("")) {
                    JOptionPane.showMessageDialog(null, "Completa tu nombre y edad");
                } else {
                    try {
                        int edad = Integer.parseInt(edadTexto);
                        String estado;

                        if (edad >= 18) {
                            estado = "mayor de edad";
                        } else {
                            estado = "menor de edad";
                        }

                        lblResumen.setText("Resumen: " + nombre + ", " + edad + " años (" + estado + ")");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingresa un numeritoo valido en la edad");
                    }
                }
            }
        });
    }

    private void createUIComponents() {
        panelPrincipal = new JPanel();
        txtNombre = new JTextField();
        txtEdad = new JTextField();
        btnResumen = new JButton();
        lblResumen = new JLabel();
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Cuestionario");
        ventana.setContentPane(new CuestionarioForm().panelPrincipal);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(450, 260);
        ventana.setVisible(true);
    }
}
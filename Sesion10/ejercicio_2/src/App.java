import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Temperatura Semanal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,450);
        frame.setLayout(new BorderLayout());

        String[] dias = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};
        JTextField[] campos = new JTextField[7];
        JPanel panelControles = new JPanel(new FlowLayout());

        for (int i = 0; i<7; i++)
        {
            panelControles.add(new JLabel(dias[i] + ":"));
            campos[i] = new JTextField("20",3);
            panelControles.add(campos[i]);
        }
        JButton btnMostrar = new JButton("Mostrar Grafico");
        panelControles.add(btnMostrar);

        Paneltemperatura panelGrafico = new Paneltemperatura();
        btnMostrar.addActionListener(e -> {
            double[] datos = new double[7];
            try{
                for (int i = 0 ; i < 7;i++)
                {
                    datos[i] = Double.parseDouble(campos[i].getText().trim());
                }
                panelGrafico.setTemperaturas(datos);
            }catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(frame, "Ingrese 7 temperaturas numericas validas");
            }
        }
        );

        frame.add(panelControles,BorderLayout.NORTH);
        frame.add(panelGrafico,BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

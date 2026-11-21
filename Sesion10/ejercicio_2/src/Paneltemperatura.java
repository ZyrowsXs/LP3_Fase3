import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
public class Paneltemperatura extends JPanel{
    private final String[] dias = {"Lun", "Mar", "Mie", "Jue", "Vie","Sab", "Dom"};
    private double[] temperaturas = {20,22,19,20,21,18,21};

    public void setTemperaturas(double[] newTemp)
    {
        this.temperaturas = newTemp;
        this.repaint();
    }

    @Override 
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int margenIzq = 50;int margenDer = 30;int margenSup = 30;int margenInf = 45;
        int anchoUtil = getWidth() - margenIzq - margenDer;  int altoUtil = getHeight() - margenSup - margenInf;

        if (anchoUtil <= 0 || altoUtil <= 0) return;

        g2d.setColor(Color.DARK_GRAY);
        g2d.drawLine(margenIzq, margenSup,margenIzq,getHeight() - margenInf);
        g2d.drawLine(margenIzq, getHeight()-margenInf, getWidth() - margenDer, getHeight() - margenInf);
        g2d.drawString("ªC", margenIzq - 25, margenSup + 5);

        double min=temperaturas[0];
        double max=temperaturas[0];

        for (double t : temperaturas)
        {
            if (t<min) min = t;if (t>max) max = t;
        }
        double rango = (max - min == 0) ? 1: max - min;


        g2d.setStroke(new BasicStroke(2f));
        int prevx = 0, prevy = 0;
        for (int i = 0; i < temperaturas.length; i++)
        {
            int x = margenIzq + (i * anchoUtil) / (temperaturas.length - 1);
            double norm = (temperaturas[i] - min)/rango;
            int y = (getHeight() - margenInf - 15) - (int) (norm * (altoUtil-30));

            if (i>0){
                g2d.setColor(new Color(43,108,176));
                g2d.drawLine(prevx,prevy,x,y);
            }

            g2d.setColor(new Color(220,38,38));
            g2d.fillOval(x - 4, y -4, 8, 8);
            g2d.setColor(Color.BLACK);
            g2d.drawString(String.format("%.1f",temperaturas[i]), x - 10, y - 8);
            g2d.drawString(dias[i], x - 10, getHeight() - margenInf + 18);
            prevx = x;
            prevy = y;
        }


    }
}

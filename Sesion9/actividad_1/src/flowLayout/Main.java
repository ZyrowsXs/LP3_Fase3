package flowLayout;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        MarcoFlowLayout marco = new MarcoFlowLayout();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(850, 120);
        marco.setVisible(true);
    }
}
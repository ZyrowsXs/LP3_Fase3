package gridLayout;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        MarcoGridLayout marco = new MarcoGridLayout();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(850, 200);
        marco.setVisible(true);
    }
}
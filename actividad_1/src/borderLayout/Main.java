package borderLayout;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        MarcoBorderLayout marco = new MarcoBorderLayout();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(850, 250);
        marco.setVisible(true);
    }
}
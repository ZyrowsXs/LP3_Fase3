import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AppEfectosSonido {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Efectos de sonido");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,140);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,15,30));

        JButton btnAplausos = new JButton("Aplausos");
        JButton btnCampana = new JButton("Campana");
        JButton btnExplosion = new JButton("Explosion");

        btnAplausos.addActionListener(e -> playSound("efectosSonido/aplausos.wav"));
        btnCampana.addActionListener(e -> playSound("efectosSonido/campana.wav"));
        btnExplosion.addActionListener(e ->playSound("efectosSonido/explosion.wav"));

        frame.add(btnAplausos);
        frame.add(btnCampana);
        frame.add(btnExplosion);
        frame.setVisible(true);
    }

    public static void playSound(String filePath)
    {
        try{
            File audioFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.addLineListener(event -> {
                if(event.getType() == LineEvent.Type.STOP){
                    clip.close();
                }
            });
            clip.start();
        }catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
        {
            JOptionPane.showMessageDialog(null, "Error al reproducir: " + filePath);
        }
    }
}

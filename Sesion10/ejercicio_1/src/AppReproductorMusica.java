import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class AppReproductorMusica extends JFrame {
    private static final String DEFAULT_AUDIO = "audioatlant-dominator-action-countdown-trailer-main-554635.wav";

    private Clip clip;
    private long pausedPos = 0;
    private boolean isPaused = false;
    private File currentFile;

    private final JLabel lblArchivo;
    private final JLabel lblEstado;

    public AppReproductorMusica() {
        super("Reproductor de Música");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 220);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel infoPanel = new JPanel(new GridLayout(2, 1, 4, 4));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 4, 12));
        lblArchivo = new JLabel("Archivo: (ninguno)", SwingConstants.CENTER);
        lblEstado = new JLabel("Estado: Detenido", SwingConstants.CENTER);
        infoPanel.add(lblArchivo);
        infoPanel.add(lblEstado);
        add(infoPanel, BorderLayout.NORTH);

        JPanel controlsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnReproducir = new JButton("Reproducir");
        JButton btnPausar = new JButton("Pausar");
        JButton btnReanudar = new JButton("Reanudar");
        controlsPanel.add(btnReproducir);
        controlsPanel.add(btnPausar);
        controlsPanel.add(btnReanudar);
        add(controlsPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 8));
        JButton btnSeleccionar = new JButton("Seleccionar .wav");
        bottomPanel.add(btnSeleccionar);
        add(bottomPanel, BorderLayout.SOUTH);

        btnReproducir.addActionListener(e -> reproducir());
        btnPausar.addActionListener(e -> pausar());
        btnReanudar.addActionListener(e -> reanudar());
        btnSeleccionar.addActionListener(e -> seleccionarArchivo());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarClip();
            }
        });

        cargarAudio(new File(DEFAULT_AUDIO));
    }

    private void cargarAudio(File file) {
        if (!file.exists()) {
            lblArchivo.setText("Archivo no encontrado: " + file.getName());
            lblEstado.setText("Estado: Sin audio");
            return;
        }
        cerrarClip();
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    SwingUtilities.invokeLater(() -> {
                        if (!isPaused && clip != null && clip.getMicrosecondPosition() >= clip.getMicrosecondLength()) {
                            pausedPos = 0;
                            lblEstado.setText("Estado: Finalizado");
                        }
                    });
                }
            });
            currentFile = file;
            pausedPos = 0;
            isPaused = false;
            lblArchivo.setText("Archivo: " + currentFile.getName());
            lblEstado.setText("Estado: Listo");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            lblEstado.setText("Estado: Error al cargar");
            JOptionPane.showMessageDialog(this,
                    "No se pudo cargar el archivo de audio:\n" + ex.getMessage(),
                    "Error de Audio",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void reproducir() {
        if (clip == null) return;
        isPaused = false;
        pausedPos = 0;
        clip.stop();
        clip.setMicrosecondPosition(0);
        clip.start();
        lblEstado.setText("Estado: Reproduciendo");
    }

    private void pausar() {
        if (clip == null || !clip.isRunning()) return;
        isPaused = true;
        pausedPos = clip.getMicrosecondPosition();
        clip.stop();
        lblEstado.setText("Estado: Pausado");
    }

    private void reanudar() {
        if (clip == null || clip.isRunning()) return;
        isPaused = false;
        clip.setMicrosecondPosition(pausedPos);
        clip.start();
        lblEstado.setText("Estado: Reproduciendo");
    }

    private void seleccionarArchivo() {
        JFileChooser chooser = new JFileChooser(currentFile != null ? currentFile.getParentFile() : new File("."));
        chooser.setFileFilter(new FileNameExtensionFilter("Archivos WAV (*.wav)", "wav"));
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            cargarAudio(chooser.getSelectedFile());
        }
    }

    private void cerrarClip() {
        if (clip != null) {
            clip.stop();
            clip.close();
            clip = null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppReproductorMusica().setVisible(true));
    }
}

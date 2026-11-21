import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class VistaCompraPasaje extends JFrame{
    private JTextField txtNombre, txtDocumento, txtFechaSalida; //Ingrese de datos por teclado
    private JCheckBox  chkAudifonos, chkManta, chkRevistas; //seleccion multiple
    private JRadioButton rbtPrimerPiso, rbtSegundoPiso; //componentes de opcion
    private ButtonGroup grupoPisos; //logica para la seleccion de una sola opion
    private JComboBox<String> cmbOrigen, cmbDestino; //
    private JList<String> lstCalidad;
    private JButton btnResumen, btnReiniciar;

    public VistaCompraPasaje()
    {
        super("--- Compra de pasajes terrestre ---");
        setLayout(new BorderLayout(10,10));

        JPanel panelCentral = new JPanel(new GridLayout(2,1,10,10));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10,15,5,15));
        panelCentral.add(crearPanelDatosPersonales());
        panelCentral.add(crearPanelOpcionesViaje());

        add(panelCentral,BorderLayout.CENTER);
        add(crearPanelBotones(), BorderLayout.SOUTH);
    }

    private JPanel crearPanelDatosPersonales()
    {
        JPanel panel = new JPanel(new GridLayout(3,2,8,8));
        panel.setBorder(BorderFactory.createTitledBorder("Datos Pasajeros"));
        this.txtNombre = new JTextField(20);
        this.txtDocumento = new JTextField(15);
        this.txtFechaSalida = new JTextField(15);

        panel.add(new JLabel("Nombres Completos"));
        panel.add(txtNombre);
        panel.add(new JLabel("Documento de Identidad"));
        panel.add(txtDocumento);
        panel.add(new JLabel("Fecha de Salidad"));
        panel.add(txtFechaSalida);

        return panel;
    }

    private JPanel crearPanelOpcionesViaje()
    {
        JPanel panel = new JPanel(new GridLayout(4,2,8,7));
        panel.setBorder(BorderFactory.createTitledBorder("Detalles del Viaje"));
        
        String[] ciudades = {"Arequipa", "Lima", "Puno" , "Cuzco", "Tacna"};
        cmbOrigen = new JComboBox<>(ciudades);
        cmbDestino = new JComboBox<>(ciudades);
        cmbDestino.setSelectedIndex(1);

        panel.add(new JLabel("Origen: "));
        panel.add(cmbOrigen);
        panel.add(new JLabel("Destino: "));
        panel.add(cmbDestino);

        rbtPrimerPiso = new JRadioButton("1er Piso",true);
        rbtSegundoPiso = new JRadioButton("2do Piso");
        grupoPisos = new ButtonGroup();
        grupoPisos.add(rbtPrimerPiso);
        grupoPisos.add(rbtSegundoPiso);

        JPanel panelPiso = new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
        panelPiso.add(rbtPrimerPiso);
        panelPiso.add(rbtSegundoPiso);

        panel.add(new JLabel("Piso: "));
        panel.add(panelPiso);

        chkAudifonos = new JCheckBox("Audifonos ");
        chkManta = new JCheckBox("Manta ");
        chkRevistas = new JCheckBox("Revistas ");

        JPanel panelServicios = new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
        panelServicios.add(chkAudifonos);
        panelServicios.add(chkManta);
        panelServicios.add(chkRevistas);

        panel.add(new JLabel("Servicios opcionales: "));
        panel.add(panelServicios);

        String[] calidades = {"Economico","Standart","VIP"};
        lstCalidad = new JList<>(calidades);
        lstCalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstCalidad.setSelectedIndex(0);

        JPanel contenedor = new JPanel(new BorderLayout(5,5));
        contenedor.add(panel, BorderLayout.CENTER);

        JPanel panelLista = new JPanel(new BorderLayout());
        panelLista.add(new JLabel("Calidad de servicio: "), BorderLayout.NORTH);
        panelLista.add(new JScrollPane(lstCalidad), BorderLayout.CENTER);
        contenedor.add(panelLista, BorderLayout.EAST);

        return contenedor;
    }

    private JPanel crearPanelBotones()
    {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,15,10));
        btnResumen = new JButton("Mostrar Resumen");
        btnReiniciar = new JButton("Reiniciar");
        panel.add(btnResumen);
        panel.add(btnReiniciar);
        return panel;
    }

    public JButton getBtnResumen() { return this.btnResumen; }
    public JButton getBtnReiniciar() { return this.btnReiniciar; }

    public String getNombres() { return this.txtNombre.getText().trim(); }
    public String getDocumento() { return this.txtDocumento.getText().trim(); }
    public String getFechaDeSalida() { return this.txtFechaSalida.getText().trim(); }
    public String getOrigen() { return (String) this.cmbOrigen.getSelectedItem(); }
    public String getDestino() { return (String) this.cmbDestino.getSelectedItem(); }
    public String getPiso() { return this.rbtPrimerPiso.isSelected() ? "1er Piso" : "2do Piso"; }
    public String getCalidad() { return this.lstCalidad.getSelectedValue(); }

    public String getServiciosSeleccionados()
    {
        StringBuilder sb = new StringBuilder();
        if (chkAudifonos.isSelected()) sb.append("Audifonos ");
        if (chkManta.isSelected()) sb.append("Manta ");
        if (chkRevistas.isSelected()) sb.append("Revistas ");
        return sb.length() > 0 ? sb.toString().trim() : "Ninguno ";
    }

    public void limpiarFormulario(){
        txtNombre.setText("");
        txtDocumento.setText("");
        txtFechaSalida.setText("");
        chkAudifonos.setSelected(false);
        chkManta.setSelected(false);
        chkRevistas.setSelected(false);
        rbtPrimerPiso.setSelected(true);
        cmbOrigen.setSelectedIndex(0);
        cmbDestino.setSelectedIndex(1);
        lstCalidad.setSelectedIndex(0);
    }
    public void mostrarMensaje(String mensaje, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, tipo);
    }
}

/*
 * COMENTARIO TEÓRICO (Laboratorio 09 - Jerarquía Swing y Administradores de Esquemas):
 * Esta clase representa la Vista del patrón MVC, extendiendo JFrame como contenedor de
 * nivel superior. Emplea componentes ligeros de javax.swing (JLabel, JTextField, JCheckBox,
 * JRadioButton, JComboBox, JList y JButton), organizados jerárquicamente mediante la técnica
 * de anidamiento de paneles (JPanel) y composición de administradores de esquema: BorderLayout
 * para las regiones estructurales principales, GridLayout para alinear en matrices uniformes
 * los datos personales y opciones, y FlowLayout para la disposición secuencial de controles
 * de selección y botones. Para la selección exclusiva de pisos se utiliza ButtonGroup junto
 * con JRadioButton, mientras que para la lista de calidades se utiliza JList envuelto en un
 * JScrollPane para garantizar el desplazamiento visual. Finalmente, encapsula el cuadro de
 * diálogo modal prefabricado JOptionPane para presentar alertas y resúmenes al usuario.
 */


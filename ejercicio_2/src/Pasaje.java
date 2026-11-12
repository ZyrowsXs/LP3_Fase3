public class Pasaje {
    private String nombre;
    private String documento;
    private String origen;
    private String destino;
    private String fechaSalida;
    private String servicios;
    private String piso;
    private String calidad;

    public Pasaje(String nombre, String documento,String origen, String destino,String fechaSalida,String servicios,String piso,String calidad)
    {
        if (nombre.isEmpty()) throw new IllegalArgumentException("El nombre no puede estar vacio");
        if (documento.isEmpty() || documento.length() != 8) throw new IllegalArgumentException("Error al momento de ingresar el numero del documento");
        if (origen.isEmpty()) throw new IllegalArgumentException("El origen no puede estar vacio");
        if (destino.isEmpty()) throw new IllegalArgumentException("El destino no puede estar vacio");
        if (fechaSalida.isEmpty()) throw new IllegalArgumentException("La Fecha de salida no puede estar vacia");
        if (servicios.isEmpty()) throw new IllegalArgumentException("Los servicios no pueden estar vacios");
        if (piso.isEmpty()) throw new IllegalArgumentException("El piso no puede estar vacio");
        if (calidad.isEmpty()) throw new IllegalArgumentException("La calidad no puede estar vacio");
        
        this.nombre = nombre;
        this.documento = documento;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.servicios = servicios;
        this.piso = piso;
        this.calidad = calidad;   
    }

    @Override 
    public String toString()
    {
        return "--- Resumen Compra --- \n" +
                "Pasajero: " + this.nombre + "\n" +
                "Documento: " + this.documento + "\n" +
                "Fecha de Viaje: " + this.fechaSalida + "\n" +
                "Origen: " + this.origen + "\n" +
                "Destino: " + this.destino + "\n" +
                "Piso: " + this.piso + "\n" +
                "Calidad: " + this.calidad + "\n" +
                "Servicios: " + this.servicios;
    }

}

/*
 * COMENTARIO TEÓRICO (Laboratorio 09 - Modelo y Encapsulamiento):
 * Esta clase constituye el Modelo dentro del patrón arquitectónico Modelo-Vista-Controlador
 * (MVC). Su objetivo teórico es encapsular el estado y las reglas de negocio de un pasaje
 * terrestre de forma totalmente independiente de la interfaz gráfica de usuario (GUI).
 * No contiene dependencias de paquetes gráficos como java.awt o javax.swing, garantizando
 * un bajo acoplamiento y alta cohesión. En su constructor implementa validaciones de
 * integridad para asegurar que atributos obligatorios (nombre, documento de 8 dígitos,
 * origen, destino, fecha, piso y calidad) no sean nulos ni vacíos, arrojando excepciones
 * de tipo IllegalArgumentException en caso de incoherencia. Finalmente, redefine el método
 * toString() para estructurar el resumen textual que será desplegado limpiamente en el
 * cuadro de diálogo JOptionPane por la capa de presentación.
 */

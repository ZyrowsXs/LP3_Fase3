package observer;

public class UsuarioObserver implements IObserver {
    private String nombre;
    public UsuarioObserver(String nombre)
    {
        this.nombre = nombre;
    }
    @Override 
    public void update(String message)
    {
        System.out.println(nombre + " - " + "Notificacion de Usuario: " + message);
    } 
}

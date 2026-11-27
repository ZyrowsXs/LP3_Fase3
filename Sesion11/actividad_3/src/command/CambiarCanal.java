package command;

public class CambiarCanal implements ICommand {    
    private Tv tv;
    private int canal;
    public CambiarCanal(Tv tv, int canal) {this.tv = tv;this.canal = canal;}
    @Override 
    public void ejecutar()
    {
        tv.cambiarCanal(canal);
    }
}

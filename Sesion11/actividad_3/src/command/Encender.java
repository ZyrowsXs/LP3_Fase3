package command;

public class Encender implements ICommand {
    private Tv tv;
    public Encender(Tv tv) {this.tv = tv;}
    @Override 
    public void ejecutar(){
        tv.encender();
    } 
}

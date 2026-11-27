package command;

public class SubirVolumen implements ICommand {
    private Tv tv;
    public SubirVolumen(Tv tv) {this.tv = tv;}
    @Override 
    public void ejecutar(){
        tv.subirVolumen();
    }
}

package command;

public class BajarVolumen implements ICommand {
    private Tv tv;
    public BajarVolumen(Tv tv) {this.tv = tv;}
    @Override 
    public void ejecutar(){
        tv.bajarVolumen();
    }
}

package command;

public class Apagar implements ICommand{ 
    private Tv tv;
    public Apagar(Tv tv) {this.tv = tv;}
    @Override 
    public void ejecutar(){
        tv.apagar();
    }
}

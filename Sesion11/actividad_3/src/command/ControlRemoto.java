package command;

public class ControlRemoto {
    private ICommand comando;
    public ControlRemoto(ICommand comando) {
        this.comando = comando;
    }
    public void setComando(ICommand comando){
        this.comando = comando;
    }
    public void presionarBoton(){
        this.comando.ejecutar();
    }
}

import command.*;


public class App {
    public static void main(String[] args) throws Exception {
        Tv  tv = new Tv();
        ControlRemoto control = new ControlRemoto(new Encender(tv));

        control.presionarBoton();

        control.setComando(new SubirVolumen(tv));
        control.presionarBoton();

        control.setComando(new CambiarCanal(tv, 42));
        control.presionarBoton();

        control.setComando(new BajarVolumen(tv));
        control.presionarBoton();

        control.setComando(new Apagar(tv));
        control.presionarBoton(); 
    }
}

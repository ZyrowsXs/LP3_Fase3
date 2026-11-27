import observer.CentroNotificaciones;
import observer.IObservable;
import observer.IObserver;
import observer.UsuarioObserver;

public class App {
    public static void main(String[] args) {
        IObservable subject = new CentroNotificaciones();
        IObserver persona1 = new UsuarioObserver("LUIS");
        IObserver persona2 = new UsuarioObserver("PEDRO");
        IObserver persona3 = new UsuarioObserver("LUISA");

        subject.attach(persona3);
        subject.attach(persona2);
        subject.attach(persona1);

        subject.notifyObservers("Nuevo descuento en pantalones");

        subject.detach(persona3);
        subject.notifyObservers("Nuevo descuento en zapatillas");
    }
}

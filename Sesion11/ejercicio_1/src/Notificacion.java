import java.util.ArrayList;
import java.util.List;

public class Notificacion {
    private List<Observer> observers = new ArrayList();

    public void suscribir(Observer observer) {
    observers.add(observer);
    }
    public void quitarSuscripcion(Observer observer){
        observers.remove(observer);

    }
    public void notificar(String message){
        for(Observer obs : observers ){
            obs.update(message);
        }
    }
}

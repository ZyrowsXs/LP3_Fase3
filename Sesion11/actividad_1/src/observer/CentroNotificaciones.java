package observer;

import java.util.ArrayList;
import java.util.List;

public class CentroNotificaciones implements IObservable {
    private List<IObserver> obs = new ArrayList<>();
    @Override 
    public void attach(IObserver ob)
    {
        this.obs.add(ob);
    }
    @Override 
    public void detach(IObserver ob)
    {
        this.obs.remove(ob);
    }
    @Override 
    public void notifyObservers(String message)
    {
        System.out.println("===========================");
        for(IObserver ob: obs)
        {
            ob.update(message);
        }
        System.out.println("===========================");
    }
}

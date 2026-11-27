package observer;

public interface IObservable {
    void attach(IObserver ob);
    void detach(IObserver ob);
    void notifyObservers(String message);
}

package rpg;

public class ConsolaCombateObserver implements IObservadorCombate {
    @Override
    public void actualizar(String evento, Personaje afectado) {
        System.out.println("  [LOG] " + evento);
    }
}

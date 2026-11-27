package rpg;

public class AlertaSaludObserver implements IObservadorCombate {
    @Override
    public void actualizar(String evento, Personaje afectado) {
        if (afectado == null) return;
        double porcentaje = (afectado.getVida() * 100.0) / afectado.getVidaMax();
        if (!afectado.estaVivo()) {
            System.out.println("  [ALERTA] ¡" + afectado.getNombre() + " ha caído derrotado!");
        } else if (porcentaje <= 30.0) {
            System.out.printf("  [ALERTA] ¡Salud crítica en %s (%.0f%% restante)!%n",
                    afectado.getNombre(), porcentaje);
        }
    }
}

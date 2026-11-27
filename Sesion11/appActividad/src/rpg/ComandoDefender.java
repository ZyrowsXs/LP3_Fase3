package rpg;

public class ComandoDefender implements IComandoRPG {
    private Personaje personaje;
    private boolean defPrevia;

    public ComandoDefender(Personaje personaje) {
        this.personaje = personaje;
    }

    @Override
    public void ejecutar() {
        defPrevia = personaje.isDefendiendo();
        personaje.activarDefensa();
    }

    @Override
    public void deshacer() {
        personaje.restaurarEstado(personaje.getVida(), personaje.getMana(), defPrevia);
    }

    @Override
    public String getNombreAccion() {
        return personaje.getNombre() + " se defendió";
    }
}

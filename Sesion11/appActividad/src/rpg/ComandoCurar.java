package rpg;

public class ComandoCurar implements IComandoRPG {
    private Personaje personaje;
    private int cantidad;
    private int vidaPrevia;

    public ComandoCurar(Personaje personaje, int cantidad) {
        this.personaje = personaje;
        this.cantidad = cantidad;
    }

    @Override
    public void ejecutar() {
        vidaPrevia = personaje.getVida();
        personaje.curar(cantidad);
    }

    @Override
    public void deshacer() {
        personaje.restaurarEstado(vidaPrevia, personaje.getMana(), personaje.isDefendiendo());
    }

    @Override
    public String getNombreAccion() {
        return personaje.getNombre() + " usó curación (+" + cantidad + " HP)";
    }
}

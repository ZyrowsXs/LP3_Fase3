package rpg;

public class ComandoAtacar implements IComandoRPG {
    private Personaje atacante;
    private Personaje objetivo;
    private int vidaPreviaObjetivo;
    private int manaPrevioAtacante;
    private boolean defPreviaObjetivo;

    public ComandoAtacar(Personaje atacante, Personaje objetivo) {
        this.atacante = atacante;
        this.objetivo = objetivo;
    }

    @Override
    public void ejecutar() {
        vidaPreviaObjetivo = objetivo.getVida();
        manaPrevioAtacante = atacante.getMana();
        defPreviaObjetivo = objetivo.isDefendiendo();
        atacante.atacar(objetivo);
    }

    @Override
    public void deshacer() {
        objetivo.restaurarEstado(vidaPreviaObjetivo, objetivo.getMana(), defPreviaObjetivo);
        atacante.restaurarEstado(atacante.getVida(), manaPrevioAtacante, atacante.isDefendiendo());
    }

    @Override
    public String getNombreAccion() {
        return atacante.getNombre() + " atacó a " + objetivo.getNombre();
    }
}

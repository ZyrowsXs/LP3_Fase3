package rpg;

public class ComandoCambiarEstrategia implements IComandoRPG {
    private Personaje personaje;
    private IEstrategiaAtaque nuevaEstrategia;
    private IEstrategiaAtaque estrategiaPrevia;

    public ComandoCambiarEstrategia(Personaje personaje, IEstrategiaAtaque nueva) {
        this.personaje = personaje;
        this.nuevaEstrategia = nueva;
    }

    @Override
    public void ejecutar() {
        estrategiaPrevia = personaje.getEstrategiaAtaque();
        personaje.setEstrategiaAtaque(nuevaEstrategia);
    }

    @Override
    public void deshacer() {
        personaje.setEstrategiaAtaque(estrategiaPrevia);
    }

    @Override
    public String getNombreAccion() {
        return personaje.getNombre() + " cambió a " + nuevaEstrategia.getNombre();
    }
}

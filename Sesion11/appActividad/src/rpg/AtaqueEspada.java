package rpg;

public class AtaqueEspada implements IEstrategiaAtaque {
    @Override
    public int calcularDanio(Personaje atacante) {
        return 18;
    }

    @Override
    public String getNombre() {
        return "Espada (18 daño físico)";
    }
}

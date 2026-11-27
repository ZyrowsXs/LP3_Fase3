package rpg;

public class AtaqueMagico implements IEstrategiaAtaque {
    @Override
    public int calcularDanio(Personaje atacante) {
        if (atacante.gastarMana(15)) {
            return 32;
        }
        System.out.println("  [INFO] Sin maná suficiente; golpe básico de bastón.");
        return 8;
    }

    @Override
    public String getNombre() {
        return "Magia Arcana (32 daño, cuesta 15 MP)";
    }
}

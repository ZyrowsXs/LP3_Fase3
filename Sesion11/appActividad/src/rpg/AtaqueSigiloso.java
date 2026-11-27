package rpg;

import java.util.Random;

public class AtaqueSigiloso implements IEstrategiaAtaque {
    private Random rand = new Random();

    @Override
    public int calcularDanio(Personaje atacante) {
        if (rand.nextInt(100) < 40) {
            System.out.println("  [CRÍTICO] ¡Golpe certero al punto débil!");
            return 36;
        }
        return 14;
    }

    @Override
    public String getNombre() {
        return "Sigilo (14 daño, 40% crítico de 36)";
    }
}

import java.util.Scanner;
import rpg.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorTurnos gestor = new GestorTurnos();

        IObservadorCombate logConsola = new ConsolaCombateObserver();
        IObservadorCombate alertaSalud = new AlertaSaludObserver();

        Personaje heroe = new Personaje("Héroe", 100, 45, new AtaqueEspada());
        Personaje dragon = new Personaje("Dragón de Ceniza", 120, 30, new AtaqueEspada());

        heroe.agregarObservador(logConsola);
        heroe.agregarObservador(alertaSalud);
        dragon.agregarObservador(logConsola);
        dragon.agregarObservador(alertaSalud);

        System.out.println("===================================================");
        System.out.println("   ARENA DE BATALLA RPG (OBSERVER+STRATEGY+COMMAND)");
        System.out.println("===================================================");

        while (heroe.estaVivo() && dragon.estaVivo()) {
            System.out.println("\n---------------------------------------------------");
            System.out.printf("HÉROE  -> HP: %d/%d | MP: %d/%d | Estilo: %s%n",
                    heroe.getVida(), heroe.getVidaMax(), heroe.getMana(), heroe.getManaMax(),
                    heroe.getEstrategiaAtaque().getNombre());
            System.out.printf("DRAGÓN -> HP: %d/%d%n", dragon.getVida(), dragon.getVidaMax());
            System.out.println("---------------------------------------------------");
            System.out.println("1. Atacar");
            System.out.println("2. Curar (+25 HP)");
            System.out.println("3. Defender (reduce próximo daño 50%)");
            System.out.println("4. Cambiar Estrategia de Ataque");
            System.out.println("5. Deshacer última acción");
            System.out.println("6. Ver historial de comandos");
            System.out.print("Tu acción: ");

            int op = sc.nextInt();
            boolean turnoEnemigo = true;

            switch (op) {
                case 1 -> gestor.ejecutarComando(new ComandoAtacar(heroe, dragon));
                case 2 -> gestor.ejecutarComando(new ComandoCurar(heroe, 25));
                case 3 -> gestor.ejecutarComando(new ComandoDefender(heroe));
                case 4 -> {
                    System.out.println("  Elige estrategia: 1) Espada  2) Magia Arcana  3) Sigilo");
                    int est = sc.nextInt();
                    IEstrategiaAtaque nueva = switch (est) {
                        case 2 -> new AtaqueMagico();
                        case 3 -> new AtaqueSigiloso();
                        default -> new AtaqueEspada();
                    };
                    gestor.ejecutarComando(new ComandoCambiarEstrategia(heroe, nueva));
                    turnoEnemigo = false;
                }
                case 5 -> {
                    gestor.deshacerUltimo();
                    turnoEnemigo = false;
                }
                case 6 -> {
                    gestor.mostrarHistorial();
                    turnoEnemigo = false;
                }
                default -> {
                    System.out.println("Opción inválida.");
                    turnoEnemigo = false;
                }
            }

            if (turnoEnemigo && dragon.estaVivo()) {
                System.out.println("\n>> Turno del Dragón de Ceniza:");
                gestor.ejecutarComando(new ComandoAtacar(dragon, heroe));
            }
        }

        System.out.println("\n===================================================");
        if (heroe.estaVivo()) {
            System.out.println("¡VICTORIA! Has derrotado al Dragón de Ceniza.");
        } else {
            System.out.println("DERROTA... El Dragón ha prevalecido.");
        }
        System.out.println("===================================================");
        sc.close();
    }
}

package rpg;

import java.util.Stack;

public class GestorTurnos {
    private Stack<IComandoRPG> historial = new Stack<>();

    public void ejecutarComando(IComandoRPG cmd) {
        cmd.ejecutar();
        historial.push(cmd);
    }

    public void deshacerUltimo() {
        if (historial.isEmpty()) {
            System.out.println("  [SISTEMA] No hay acciones previas para deshacer.");
            return;
        }
        IComandoRPG ultimo = historial.pop();
        System.out.println("  [DESHACER] Revirtiendo: " + ultimo.getNombreAccion());
        ultimo.deshacer();
    }

    public void mostrarHistorial() {
        System.out.println("\n--- Historial de Comandos Ejecutados ---");
        if (historial.isEmpty()) {
            System.out.println("  (Vacío)");
        } else {
            for (int i = 0; i < historial.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + historial.get(i).getNombreAccion());
            }
        }
    }
}

package ej3.command;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Invocador que ejecuta comandos de pedidos y mantiene una pila para deshacer.
 */
public class InvocadorPedidos {
    private final Deque<ComandoPedido> historial = new ArrayDeque<>();

    public boolean ejecutarComando(ComandoPedido comando) {
        if (comando != null && comando.ejecutar()) {
            historial.push(comando);
            return true;
        }
        return false;
    }

    public boolean deshacerUltimo() {
        if (historial.isEmpty()) {
            return false;
        }
        ComandoPedido ultimo = historial.pop();
        ultimo.deshacer();
        return true;
    }

    public boolean puedeDeshacer() {
        return !historial.isEmpty();
    }
}

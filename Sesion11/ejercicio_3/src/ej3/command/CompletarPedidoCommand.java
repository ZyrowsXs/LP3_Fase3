package ej3.command;

import ej3.modelo.GestorPedidos;

/**
 * Comando para completar un pedido existente y revertirlo a pendiente al deshacer.
 */
public class CompletarPedidoCommand implements ComandoPedido {
    private final GestorPedidos gestor;
    private final int pedidoId;
    private boolean ejecutado;

    public CompletarPedidoCommand(GestorPedidos gestor, int pedidoId) {
        this.gestor = gestor;
        this.pedidoId = pedidoId;
    }

    @Override
    public boolean ejecutar() {
        ejecutado = gestor.completarPedido(pedidoId);
        return ejecutado;
    }

    @Override
    public void deshacer() {
        if (ejecutado) {
            gestor.marcarPendiente(pedidoId);
            ejecutado = false;
        }
    }

    @Override
    public String getNombre() {
        return "Completar pedido #" + pedidoId;
    }
}

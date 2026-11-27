package ej3.command;

import ej3.modelo.GestorPedidos;
import ej3.modelo.Pedido;
import ej3.strategy.EstrategiaPedido;

/**
 * Comando para registrar un nuevo pedido y poder deshacer su registro.
 */
public class RegistrarPedidoCommand implements ComandoPedido {
    private final GestorPedidos gestor;
    private final String cliente;
    private final String detalle;
    private final double montoBase;
    private final EstrategiaPedido estrategia;
    private Pedido pedidoRegistrado;

    public RegistrarPedidoCommand(
            GestorPedidos gestor,
            String cliente,
            String detalle,
            double montoBase,
            EstrategiaPedido estrategia) {
        this.gestor = gestor;
        this.cliente = cliente;
        this.detalle = detalle;
        this.montoBase = montoBase;
        this.estrategia = estrategia;
    }

    @Override
    public boolean ejecutar() {
        pedidoRegistrado = gestor.registrarPedido(cliente, detalle, montoBase, estrategia);
        return true;
    }

    @Override
    public void deshacer() {
        if (pedidoRegistrado != null) {
            gestor.eliminarPedidoPorId(pedidoRegistrado.getId());
            pedidoRegistrado = null;
        }
    }

    @Override
    public String getNombre() {
        return "Registrar pedido";
    }
}

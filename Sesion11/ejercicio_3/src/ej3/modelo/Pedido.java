package ej3.modelo;

import ej3.strategy.EstrategiaPedido;

/**
 * Entidad que representa un pedido con estrategia de cálculo y estado.
 */
public class Pedido {
    private final int id;
    private final String cliente;
    private final String detalle;
    private final double montoBase;
    private final EstrategiaPedido estrategia;
    private final double costoFinal;
    private EstadoPedido estado;

    public Pedido(int id, String cliente, String detalle, double montoBase, EstrategiaPedido estrategia) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID del pedido debe ser positivo.");
        }
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
        }
        if (detalle == null || detalle.isBlank()) {
            throw new IllegalArgumentException("El detalle del pedido no puede estar vacío.");
        }
        if (Double.isNaN(montoBase) || Double.isInfinite(montoBase) || montoBase <= 0) {
            throw new IllegalArgumentException("El monto base debe ser mayor que cero.");
        }
        if (estrategia == null) {
            throw new IllegalArgumentException("Debe seleccionar una estrategia válida.");
        }

        this.id = id;
        this.cliente = cliente.trim();
        this.detalle = detalle.trim();
        this.montoBase = montoBase;
        this.estrategia = estrategia;
        this.costoFinal = estrategia.calcularCostoFinal(montoBase);
        this.estado = EstadoPedido.PENDIENTE;
    }

    public void completar() {
        this.estado = EstadoPedido.COMPLETADO;
    }

    public void marcarPendiente() {
        this.estado = EstadoPedido.PENDIENTE;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getDetalle() {
        return detalle;
    }

    public double getMontoBase() {
        return montoBase;
    }

    public EstrategiaPedido getEstrategia() {
        return estrategia;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public EstadoPedido getEstado() {
        return estado;
    }
}

package ej3.strategy;

/**
 * Estrategia de cálculo de costo final y condiciones de entrega para un pedido.
 */
public interface EstrategiaPedido {
    String getNombre();
    String getDescripcion();
    double calcularCostoFinal(double montoBase);
}

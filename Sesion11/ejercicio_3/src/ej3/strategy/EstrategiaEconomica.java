package ej3.strategy;

/**
 * Estrategia económica: aplica 5% de descuento y entrega estándar en 3-5 días.
 */
public class EstrategiaEconomica implements EstrategiaPedido {
    @Override
    public String getNombre() {
        return "Económica (-5%)";
    }

    @Override
    public String getDescripcion() {
        return "Descuento del 5%, entrega estándar 3-5 días";
    }

    @Override
    public double calcularCostoFinal(double montoBase) {
        return montoBase * 0.95;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}

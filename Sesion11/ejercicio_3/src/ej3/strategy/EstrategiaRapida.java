package ej3.strategy;

/**
 * Estrategia rápida: aplica 15% de recargo y entrega en 24h.
 */
public class EstrategiaRapida implements EstrategiaPedido {
    @Override
    public String getNombre() {
        return "Rápida (+15%)";
    }

    @Override
    public String getDescripcion() {
        return "Recargo del 15%, entrega prioritaria 24h";
    }

    @Override
    public double calcularCostoFinal(double montoBase) {
        return montoBase * 1.15;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}

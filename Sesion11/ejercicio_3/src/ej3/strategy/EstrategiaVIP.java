package ej3.strategy;

/**
 * Estrategia VIP: suma S/ 20.00 con prioridad exclusiva y empaque premium.
 */
public class EstrategiaVIP implements EstrategiaPedido {
    private static final double CARGO_VIP = 20.00;

    @Override
    public String getNombre() {
        return "VIP (+S/ 20.00)";
    }

    @Override
    public String getDescripcion() {
        return "Adicional S/ 20.00, prioridad exclusiva y empaque premium";
    }

    @Override
    public double calcularCostoFinal(double montoBase) {
        return montoBase + CARGO_VIP;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}

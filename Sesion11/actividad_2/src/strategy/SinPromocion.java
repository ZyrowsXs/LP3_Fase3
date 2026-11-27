package strategy;

public class SinPromocion implements IEstrategiaPromocion {
    @Override public double aplicarPromocion(double monto){
        return monto;
    }
}

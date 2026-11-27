package strategy;

public class PromocionLiquidacion implements IEstrategiaPromocion {
    @Override 
    public double aplicarPromocion(double monto){
        return monto * 0.7;
    }
}

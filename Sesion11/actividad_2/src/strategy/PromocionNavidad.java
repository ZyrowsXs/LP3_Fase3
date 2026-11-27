package strategy;

public class PromocionNavidad implements IEstrategiaPromocion {
    @Override 
    public double aplicarPromocion(double monto){
        return monto * 0.75; 
    }
}

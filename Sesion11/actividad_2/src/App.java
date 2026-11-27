import strategy.CalculadoraPromociones;
import strategy.PromocionLiquidacion;
import strategy.PromocionNavidad;
import strategy.SinPromocion;

public class App {
    public static void main(String[] args) throws Exception {
        CalculadoraPromociones calculadoraPromociones = new CalculadoraPromociones(new SinPromocion());
        calculadoraPromociones.calcularPrecio(205);
        calculadoraPromociones.setEstrategia(new PromocionNavidad());
        calculadoraPromociones.calcularPrecio(205);
        calculadoraPromociones.setEstrategia(new PromocionLiquidacion());
        calculadoraPromociones.calcularPrecio(205);
    }
}

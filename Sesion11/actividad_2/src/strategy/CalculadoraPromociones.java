package strategy;

public class CalculadoraPromociones {
    private IEstrategiaPromocion estrategia;
    public CalculadoraPromociones(IEstrategiaPromocion estrategia){
        this.estrategia = estrategia;
    }
    public void calcularPrecio(double monto)
    {
        System.out.println("=======");
        System.out.println("Precio: " + estrategia.aplicarPromocion(monto) + 
        "\n Estrategia -" + estrategia.getClass().getSimpleName() + "-");
        System.out.println("=======");
    }
    public void setEstrategia(IEstrategiaPromocion estrategia) {this.estrategia = estrategia;}
}

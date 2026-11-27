import java.util.List;
public class SinDescuento implements DiscountStrategy{
    public double applyDiscount(List<Producto> productos ){
        double total = 0;
        for(Producto pr: productos){
            total= total + pr.getPrecio();
        }
        return total;
    }
}

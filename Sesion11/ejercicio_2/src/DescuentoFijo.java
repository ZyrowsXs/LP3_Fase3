import java.util.List;
public class DescuentoFijo implements DiscountStrategy {
    @Override 
    public double applyDiscount(List<Producto> productos){
        double total=0;
        for (Producto pr: productos){
            total=total + pr.getPrecio();
        }
        return total*0.90;

    }
}
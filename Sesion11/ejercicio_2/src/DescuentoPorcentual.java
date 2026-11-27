import java.util.List;

public class DescuentoPorcentual implements DiscountStrategy {
    @Override
    public double applyDiscount(List<Producto> productos) {
        double total = 0;
        for (Producto pr : productos) {
            total += pr.getPrecio();
        }

        if (productos.size() == 2 && productos.get(0).getNombre().equalsIgnoreCase(productos.get(1).getNombre())) {
            return total * 0.70;
        }

        return total;
    }
}
import java.util.List;

public class DescuentoPorcentualAcumulado implements DiscountStrategy {
    @Override
    public double applyDiscount(List<Producto> productos) {
        double total = 0;
        for (Producto pr : productos) {
            total += pr.getPrecio();
        }

        if (productos.size() >= 3) {
            double precioMinimo = productos.get(0).getPrecio();
            for (Producto pr : productos) {
                if (pr.getPrecio() < precioMinimo) {
                    precioMinimo = pr.getPrecio();
                }
            }
            return total - (precioMinimo * 0.50);
        }

        return total;
    }
}
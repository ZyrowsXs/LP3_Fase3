import java.util.ArrayList;
import java.util.List;

public class CalculadoraDePrecios {
    private DiscountStrategy discountStrategy = new SinDescuento();
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculatePrice() {
        return discountStrategy.applyDiscount(productos);
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
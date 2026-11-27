import java.util.List;
interface DiscountStrategy {
    double applyDiscount(List<Producto> productos);
}
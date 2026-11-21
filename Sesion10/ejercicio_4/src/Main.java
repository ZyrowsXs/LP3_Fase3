import javax.swing.SwingUtilities;

/**
 * Punto de entrada para el Ejercicio 1 (MVC de Producto en memoria).
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Producto producto = new Producto("Laptop Lenovo IdeaPad", 2499.90, 15, "Computación");
            ProductoView view = new ProductoView();
            new ProductoController(producto, view);
            view.setVisible(true);
        });
    }
}

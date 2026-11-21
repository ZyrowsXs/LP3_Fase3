import java.util.Locale;

/**
 * Controlador MVC que coordina el modelo Producto y la vista ProductoView.
 */
public class ProductoController {
    private final Producto model;
    private final ProductoView view;

    /**
     * Inicializa el controlador, carga el estado inicial en la vista y registra eventos.
     */
    public ProductoController(Producto model, ProductoView view) {
        this.model = model;
        this.view = view;

        cargarVistaDesdeModelo();
        this.view.addActualizarListener(e -> actualizarProducto());
    }

    private void cargarVistaDesdeModelo() {
        view.setCampos(
                model.getNombre(),
                String.format(Locale.US, "%.2f", model.getPrecio()),
                String.valueOf(model.getCantidadStock()),
                model.getCategoria()
        );
        actualizarResumen();
    }

    private void actualizarProducto() {
        String nombre = view.getNombreInput();
        String categoria = view.getCategoriaInput();
        if (nombre.isEmpty() || categoria.isEmpty()) {
            view.mostrarError("El nombre del producto y la categoría no pueden estar vacíos.");
            return;
        }

        double precio;
        try {
            precio = Double.parseDouble(view.getPrecioInput());
        } catch (NumberFormatException ex) {
            view.mostrarError("El precio debe ser un número válido.");
            return;
        }
        if (!Double.isFinite(precio) || precio < 0) {
            view.mostrarError("El precio no puede ser negativo ni inválido.");
            return;
        }

        int stock;
        try {
            stock = Integer.parseInt(view.getCantidadStockInput());
        } catch (NumberFormatException ex) {
            view.mostrarError("La cantidad en stock debe ser un número entero válido.");
            return;
        }
        if (stock < 0) {
            view.mostrarError("La cantidad en stock no puede ser negativa.");
            return;
        }

        model.setNombre(nombre);
        model.setPrecio(precio);
        model.setCantidadStock(stock);
        model.setCategoria(categoria);

        actualizarResumen();
    }

    private void actualizarResumen() {
        String resumen = String.format(
                Locale.US,
                "Prod: %s | Precio: %.2f | Stock: %d | Cat: %s",
                model.getNombre(),
                model.getPrecio(),
                model.getCantidadStock(),
                model.getCategoria()
        );
        view.setResumenProducto(resumen);
    }
}

package ej3.command;

/**
 * Interfaz Command para encapsular operaciones sobre pedidos con soporte de deshacer.
 */
public interface ComandoPedido {
    boolean ejecutar();
    void deshacer();
    String getNombre();
}

package ej3.observer;

/**
 * Interfaz Subject para gestionar y notificar observadores de pedidos.
 */
public interface SujetoPedidos {
    void agregarObservador(ObservadorPedido observador);
    void eliminarObservador(ObservadorPedido observador);
    void notificarObservadores(String evento);
}

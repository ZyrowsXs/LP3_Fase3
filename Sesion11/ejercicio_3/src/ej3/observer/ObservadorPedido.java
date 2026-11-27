package ej3.observer;

import ej3.modelo.Pedido;
import java.util.List;

/**
 * Interfaz Observer para recibir notificaciones ante cambios en los pedidos.
 */
public interface ObservadorPedido {
    void actualizar(String evento, List<Pedido> pedidos);
}

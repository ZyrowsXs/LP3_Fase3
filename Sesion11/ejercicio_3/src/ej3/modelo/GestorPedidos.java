package ej3.modelo;

import ej3.observer.ObservadorPedido;
import ej3.observer.SujetoPedidos;
import ej3.strategy.EstrategiaPedido;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Modelo principal que administra los pedidos y notifica a los observadores.
 */
public class GestorPedidos implements SujetoPedidos {
    private final List<Pedido> pedidos = new ArrayList<>();
    private final List<ObservadorPedido> observadores = new ArrayList<>();
    private int siguienteId = 1;

    @Override
    public void agregarObservador(ObservadorPedido observador) {
        if (observador != null && !observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    @Override
    public void eliminarObservador(ObservadorPedido observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(String evento) {
        List<Pedido> copia = getPedidos();
        for (ObservadorPedido observador : observadores) {
            observador.actualizar(evento, copia);
        }
    }

    public Pedido registrarPedido(String cliente, String detalle, double montoBase, EstrategiaPedido estrategia) {
        Pedido pedido = new Pedido(siguienteId, cliente, detalle, montoBase, estrategia);
        siguienteId++;
        pedidos.add(pedido);
        notificarObservadores("Pedido #" + pedido.getId() + " registrado (" + pedido.getCliente() + ")");
        return pedido;
    }

    public boolean eliminarPedidoPorId(int id) {
        Iterator<Pedido> it = pedidos.iterator();
        while (it.hasNext()) {
            Pedido p = it.next();
            if (p.getId() == id) {
                it.remove();
                notificarObservadores("Pedido #" + id + " eliminado (deshacer registro)");
                return true;
            }
        }
        return false;
    }

    public boolean completarPedido(int id) {
        Pedido pedido = buscarPorId(id);
        if (pedido == null || pedido.getEstado() == EstadoPedido.COMPLETADO) {
            return false;
        }
        pedido.completar();
        notificarObservadores("Pedido #" + id + " completado");
        return true;
    }

    public boolean marcarPendiente(int id) {
        Pedido pedido = buscarPorId(id);
        if (pedido == null || pedido.getEstado() == EstadoPedido.PENDIENTE) {
            return false;
        }
        pedido.marcarPendiente();
        notificarObservadores("Pedido #" + id + " revertido a pendiente");
        return true;
    }

    public List<Pedido> getPedidos() {
        return Collections.unmodifiableList(new ArrayList<>(pedidos));
    }

    public int getTotalPedidos() {
        return pedidos.size();
    }

    public int getCantidadPendientes() {
        int count = 0;
        for (Pedido p : pedidos) {
            if (p.getEstado() == EstadoPedido.PENDIENTE) {
                count++;
            }
        }
        return count;
    }

    public int getCantidadCompletados() {
        int count = 0;
        for (Pedido p : pedidos) {
            if (p.getEstado() == EstadoPedido.COMPLETADO) {
                count++;
            }
        }
        return count;
    }

    public double getTotalRecaudado() {
        double total = 0.0;
        for (Pedido p : pedidos) {
            if (p.getEstado() == EstadoPedido.COMPLETADO) {
                total += p.getCostoFinal();
            }
        }
        return total;
    }

    private Pedido buscarPorId(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}

package rpg;

import java.util.ArrayList;
import java.util.List;

public class Personaje {
    private String nombre;
    private int vida;
    private int vidaMax;
    private int mana;
    private int manaMax;
    private boolean defendiendo = false;
    private IEstrategiaAtaque estrategiaAtaque;
    private List<IObservadorCombate> observadores = new ArrayList<>();

    public Personaje(String nombre, int vidaMax, int manaMax, IEstrategiaAtaque estrategiaInicial) {
        this.nombre = nombre;
        this.vidaMax = vidaMax;
        this.vida = vidaMax;
        this.manaMax = manaMax;
        this.mana = manaMax;
        this.estrategiaAtaque = estrategiaInicial;
    }

    public void agregarObservador(IObservadorCombate obs) { observadores.add(obs); }
    public void eliminarObservador(IObservadorCombate obs) { observadores.remove(obs); }

    private void notificar(String evento) {
        for (IObservadorCombate obs : observadores) {
            obs.actualizar(evento, this);
        }
    }

    public void setEstrategiaAtaque(IEstrategiaAtaque nueva) {
        this.estrategiaAtaque = nueva;
        notificar(nombre + " cambia su estilo a: " + nueva.getNombre());
    }

    public IEstrategiaAtaque getEstrategiaAtaque() { return estrategiaAtaque; }

    public int atacar(Personaje objetivo) {
        int danio = estrategiaAtaque.calcularDanio(this);
        objetivo.recibirDanio(danio, this.nombre);
        return danio;
    }

    public void recibirDanio(int danio, String origen) {
        int danioFinal = defendiendo ? danio / 2 : danio;
        defendiendo = false;
        vida = Math.max(0, vida - danioFinal);
        notificar(nombre + " recibe " + danioFinal + " de daño de " + origen
                + " (HP: " + vida + "/" + vidaMax + ").");
    }

    public void curar(int cantidad) {
        int antes = vida;
        vida = Math.min(vidaMax, vida + cantidad);
        notificar(nombre + " se cura +" + (vida - antes) + " HP (HP: " + vida + "/" + vidaMax + ").");
    }

    public void activarDefensa() {
        defendiendo = true;
        notificar(nombre + " adopta postura defensiva (reduce el próximo daño a la mitad).");
    }

    public boolean gastarMana(int costo) {
        if (mana >= costo) {
            mana -= costo;
            return true;
        }
        return false;
    }

    public void restaurarEstado(int vidaAnterior, int manaAnterior, boolean defAnterior) {
        this.vida = vidaAnterior;
        this.mana = manaAnterior;
        this.defendiendo = defAnterior;
        notificar("Estado de " + nombre + " restaurado (HP: " + vida + ", MP: " + mana + ").");
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getVidaMax() { return vidaMax; }
    public int getMana() { return mana; }
    public int getManaMax() { return manaMax; }
    public boolean isDefendiendo() { return defendiendo; }
    public boolean estaVivo() { return vida > 0; }
}

package BusinessLogic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon implements Serializable {

    private String nombre;
    private TipoPokemon tipo;
    private EstadoPokemon estadoActual;
    private int vida;
    private int puntosAtaque;
    private List<Ataque> ataques;

    public Pokemon(String nombre, TipoPokemon tipo, int vida, int puntosAtaque) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.puntosAtaque = puntosAtaque;
        this.estadoActual = EstadoPokemon.NORMAL;
        this.ataques = new ArrayList<>(); 
    }

    public String getNombre() {
        return nombre;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public EstadoPokemon getEstadoActual() {
        return estadoActual;
    }

    public void aplicarEstado(EstadoPokemon estado) {
        this.estadoActual = estado;
    }

    public List<Ataque> getAtaques() { 
        return ataques;
    }

    public void agregarAtaque(Ataque ataque) {
        ataques.add(ataque);
    }

    public boolean tieneEstado(EstadoPokemon estado) { 
        return this.estadoActual == estado;
    }

    public void recibirDaño(int daño) {
        vida -= daño;
        if (vida < 0) {
            vida = 0;
        }
    }

    public abstract int atacar(int indiceAtaque, Pokemon defensor);

    public abstract void entrenar();

    public void mostrarEfectoDelEstado() {
        if (estadoActual == EstadoPokemon.NORMAL) {
            return;
        }
        switch (estadoActual) {
            case PARALIZADO:
                puntosAtaque = (int) (puntosAtaque * 0.5);
                break;
            case QUEMADO:
                recibirDaño(estadoActual.getDañoPorTurno());
                break;
            case CONGELADO:
                System.out.println(nombre + " está congelado y no puede atacar.");
                break;
            case VENENO:
                recibirDaño(estadoActual.getDañoPorTurno());
                break;
            case DORMIDO:
                System.out.println(nombre + " está dormido y no puede atacar.");
                break;
            case CONFUSO:
                break;
            case FURIA:
                puntosAtaque = (int) (puntosAtaque * estadoActual.getModificadorAtaque());
                break;
            default:
                break;
        }
    }
}


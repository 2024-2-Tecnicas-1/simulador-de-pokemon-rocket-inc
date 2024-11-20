package BusinessLogic;

import java.util.Random;

public class Ataque {
    private String nombre;
    private TipoPokemon tipo;
    private int dañoBase;
    private EstadoPokemon estadoAplicado;
    private double probabilidadEstado;   

    public Ataque(String nombre, TipoPokemon tipo, int dañoBase, EstadoPokemon estadoAplicado, double probabilidadEstado) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.dañoBase = dañoBase;
        this.estadoAplicado = estadoAplicado;
        this.probabilidadEstado = probabilidadEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public int getDañoBase() {
        return dañoBase;
    }

    public EstadoPokemon getEstadoAplicado() {
        return estadoAplicado;
    }

    public double getProbabilidadEstado() {
        return probabilidadEstado;
    }
    public int calcularDaño(TipoPokemon tipoDefensor) {
        double factor = tipo.calcularFactorMultiplicador(this.tipo, tipoDefensor);
        return (int) (dañoBase * factor);
    }
    public void aplicarAtaque(Pokemon defensor) {
        int daño = calcularDaño(defensor.getTipo());
        defensor.recibirDaño(daño);

        if (Math.random() < probabilidadEstado) {
            aplicarEstado(defensor, estadoAplicado);
        }
    }
    private void aplicarEstado(Pokemon defensor, EstadoPokemon estado) {
        switch (estado) {
            case PARALIZADO:
                System.out.println(defensor.getNombre() + " está paralizado y podría no moverse.");
                break;
            case QUEMADO:
                System.out.println(defensor.getNombre() + " está quemado y pierde vida con el tiempo.");
                break;
            case CONGELADO:
                System.out.println(defensor.getNombre() + " está congelado y no puede moverse.");
                break;
            case VENENO:
                System.out.println(defensor.getNombre() + " está envenenado y pierde vida con el tiempo.");
                break;
            case DORMIDO:
                System.out.println(defensor.getNombre() + " está dormido y no puede atacar.");
                break;
            case CONFUSO:
                System.out.println(defensor.getNombre() + " está confundido y podría dañarse a sí mismo.");
                break;
            case FURIA:
                System.out.println(defensor.getNombre() + " está lleno de furia y su ataque se ha incrementado.");
                break;
            default:
                System.out.println("El estado no tiene efectos definidos.");
                break;
        }
        defensor.aplicarEstado(estado); 
    }
}


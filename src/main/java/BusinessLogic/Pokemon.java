package BusinessLogic;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public abstract class Pokemon implements Serializable {

    private String nombre;
    private int salud;
    private int puntosAtaque;
    private Set<EstadoPokemon> estados;

    public Pokemon(String nombre, int salud, int puntosAtaque) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntosAtaque = puntosAtaque;
        this.estados = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        if (salud < 0) {
            this.salud = 0;
        } else {
            this.salud = salud;
        }
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        if (puntosAtaque < 0) {
            System.out.println("Los puntos de ataque no pueden ser negativos.");
        } else {
            this.puntosAtaque = puntosAtaque;
        }
    }

    public void agregarEstado(EstadoPokemon estado) {
        this.estados.add(estado);
    }

    public void eliminarEstado(EstadoPokemon estado) {
        this.estados.remove(estado);
    }

    public boolean tieneEstado(EstadoPokemon estado) {
        return this.estados.contains(estado);
    }

    public Set<EstadoPokemon> getEstados() {
        return this.estados;
    }

    public abstract int atacar(Pokemon oponente);

    public abstract void recibirDaño(int daño);

    public abstract void entrenar();

    public void aplicarEfectosDeEstados() {
        if (tieneEstado(EstadoPokemon.QUEMADO)) {

            int dañoQuemadura = this.salud / 16;
            this.salud -= dañoQuemadura;

        }

        if (tieneEstado(EstadoPokemon.VENENO)) {

            int dañoVeneno = this.salud / 8;
            this.salud -= dañoVeneno;

        }

        if (tieneEstado(EstadoPokemon.PARALIZADO)) {

        }

        if (tieneEstado(EstadoPokemon.DORMIDO)) {

        }

    }
}

package BusinessLogic;

import java.io.Serializable;

public abstract class Pokemon implements Serializable {

    private String nombre;
    private int salud;
    private int puntosAtaque;

    public Pokemon(String nombre, int salud, int puntosAtaque) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntosAtaque = puntosAtaque;
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

    public abstract void atacar(Pokemon oponente);

    public abstract void recibirDaño(int daño);

    public abstract void entrenar();

}

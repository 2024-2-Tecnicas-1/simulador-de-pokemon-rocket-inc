package BusinessLogic;

import java.util.List;
import java.util.ArrayList;

public class Farfetchd extends Pokemon {

    private final List<Ataque> ataques;

    public Farfetchd(String nombre) {
        super(nombre, TipoPokemon.NORMAL, 52, 90);
        ataques = new ArrayList<>();
        cargarAtaques();
    }

    private void cargarAtaques() {
        Ataque picotazo = new Ataque("Picotazo", TipoPokemon.VOLADOR, 45, EstadoPokemon.NORMAL, 0.2);
        Ataque ataqueArena = new Ataque("Ataque arena", TipoPokemon.TIERRA, 20, EstadoPokemon.NORMAL, 0.3);
        Ataque malicioso = new Ataque("Malicioso", TipoPokemon.NORMAL, 0, EstadoPokemon.NORMAL, 0.2);

        ataques.add(picotazo);
        ataques.add(ataqueArena);
        ataques.add(malicioso);
    }

    @Override
    public int atacar(int indiceAtaque, Pokemon defensor) {
        if (indiceAtaque < 0 || indiceAtaque >= ataques.size()) {
            System.out.println("Índice de ataque no válido.");
            return 0;
        }
        int daño = ataques.get(indiceAtaque).calcularDaño(defensor.getTipo());
        defensor.recibirDaño(daño);

        return daño;
    }

    @Override
    public void entrenar() {
        System.out.println(getNombre() + " está entrenando.");
        int incremento = 6;
        int nuevosPuntosAtaque = getPuntosAtaque() + incremento;
        System.out.println(getNombre() + " ha aumentado sus puntos de ataque a " + nuevosPuntosAtaque);
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }
}


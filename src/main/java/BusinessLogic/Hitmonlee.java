package BusinessLogic;

import java.util.List;
import java.util.ArrayList;

public class Hitmonlee extends Pokemon {

    private final List<Ataque> ataques;

    public Hitmonlee(String nombre) {
        super(nombre, TipoPokemon.LUCHA, 50, 120);
        ataques = new ArrayList<>();
        cargarAtaques();
    }

    private void cargarAtaques() {
        Ataque sorpresa = new Ataque("sorpresa", TipoPokemon.LUCHA, 50, EstadoPokemon.NORMAL, 0.3);
        Ataque placaje = new Ataque("placaje", TipoPokemon.LUCHA, 0, EstadoPokemon.NORMAL, 0.2);
        Ataque refuerzo = new Ataque("refuerzo", TipoPokemon.LUCHA, 40, EstadoPokemon.NORMAL, 0.1);

        ataques.add(sorpresa);
        ataques.add(placaje);
        ataques.add(refuerzo);
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


package BusinessLogic;

import java.util.List;
import java.util.ArrayList;

public class Onix extends Pokemon {

    private final List<Ataque> ataques;

    public Onix(String nombre) {
        super(nombre, TipoPokemon.ROCA, 35, 45);
        ataques = new ArrayList<>();
        cargarAtaques();
    }

    private void cargarAtaques() {
        Ataque rodar = new Ataque("Rodar", TipoPokemon.ROCA, 40, EstadoPokemon.NORMAL, 0.2);
        Ataque placaje = new Ataque("Placaje", TipoPokemon.NORMAL, 35, EstadoPokemon.NORMAL, 0.1);
        Ataque terratemblor = new Ataque("Terratemblor", TipoPokemon.TIERRA, 60, EstadoPokemon.NORMAL, 0.3);

        ataques.add(rodar);
        ataques.add(placaje);
        ataques.add(terratemblor);
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

    @Override
    public List<Ataque> getAtaques() {
        return ataques;
    }
}

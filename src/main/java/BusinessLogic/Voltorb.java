package BusinessLogic;

import java.util.List;
import java.util.ArrayList;

public class Voltorb extends Pokemon {

    private final List<Ataque> ataques;

    public Voltorb(String nombre) {
        super(nombre, TipoPokemon.ELECTRICO, 40, 30);
        ataques = new ArrayList<>();
        cargarAtaques();
    }

    private void cargarAtaques() {
        Ataque carga = new Ataque("Carga", TipoPokemon.ELECTRICO, 0, EstadoPokemon.PARALIZADO, 0.3);
        Ataque placaje = new Ataque("Placaje", TipoPokemon.NORMAL, 35, EstadoPokemon.NORMAL, 0.2);
        Ataque impactrueno = new Ataque("Impactrueno", TipoPokemon.ELECTRICO, 40, EstadoPokemon.PARALIZADO, 0.3);

        ataques.add(carga);
        ataques.add(placaje);
        ataques.add(impactrueno);
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

    /**
     *
     * @return
     */
    @Override
    public List<Ataque> getAtaques() {
        return ataques;
    }
}


package BusinessLogic;

import java.util.List;
import java.util.ArrayList;

public class Tentacool extends Pokemon {

    private final List<Ataque> ataques;

    public Tentacool(String nombre) {
        super(nombre, TipoPokemon.AGUA, 40, 40);
        ataques = new ArrayList<>();
        cargarAtaques();
    }

    private void cargarAtaques() {
        Ataque acido = new Ataque("Ácido", TipoPokemon.VENENO, 30, EstadoPokemon.VENENO, 0.3);
        Ataque supersonico = new Ataque("Supersónico", TipoPokemon.NORMAL, 0, EstadoPokemon.CONFUSO, 0.2);
        Ataque hidropulso = new Ataque("Hidropulso", TipoPokemon.AGUA, 60, EstadoPokemon.NORMAL, 0.3);

        ataques.add(acido);
        ataques.add(supersonico);
        ataques.add(hidropulso);
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


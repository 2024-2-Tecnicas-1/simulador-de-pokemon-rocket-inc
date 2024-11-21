package BusinessLogic;

import java.util.List;
import java.util.ArrayList;

public class Exeggcute extends Pokemon {

    private final List<Ataque> ataques;

    public Exeggcute(String nombre) {
        super(nombre, TipoPokemon.PLANTA, 60, 40);
        ataques = new ArrayList<>();
        cargarAtaques();
    }

    private void cargarAtaques() {
        Ataque absorber = new Ataque("Absorber", TipoPokemon.PLANTA, 20, EstadoPokemon.NORMAL, 0.2);
        Ataque hipnosis = new Ataque("Hipnosis", TipoPokemon.PSIQUICO, 0, EstadoPokemon.DORMIDO, 0.3);
        Ataque reflejo = new Ataque("Reflejo", TipoPokemon.PSIQUICO, 0, EstadoPokemon.NORMAL, 0.3);

        ataques.add(absorber);
        ataques.add(hipnosis);
        ataques.add(reflejo);
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


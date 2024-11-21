package BusinessLogic;

import java.util.List;
import java.util.ArrayList;

public class Zubat extends Pokemon {

    private final List<Ataque> ataques;

    public Zubat(String nombre) {
        super(nombre, TipoPokemon.VENENO, 40, 45);
        ataques = new ArrayList<>();
        cargarAtaques();
    }

    private void cargarAtaques() {
        Ataque tornado = new Ataque("Tornado", TipoPokemon.VOLADOR, 40, EstadoPokemon.NORMAL, 0.2);
        Ataque hipnosis = new Ataque("Hipnosis", TipoPokemon.PSIQUICO, 0, EstadoPokemon.DORMIDO, 0.3);
        Ataque venenoX = new Ataque("Veneno X", TipoPokemon.VENENO, 50, EstadoPokemon.VENENO, 0.4);

        ataques.add(tornado);
        ataques.add(hipnosis);
        ataques.add(venenoX);
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


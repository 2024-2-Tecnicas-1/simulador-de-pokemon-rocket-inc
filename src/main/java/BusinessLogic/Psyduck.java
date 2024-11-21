package BusinessLogic;

import java.util.List;
import java.util.ArrayList;

public class Psyduck extends Pokemon {

    private final List<Ataque> ataques; 

    public Psyduck(String nombre) {
        super(nombre, TipoPokemon.PSIQUICO, 50, 52);
        ataques = new ArrayList<>();
        cargarAtaques(); 
    }

    private void cargarAtaques() {
        Ataque confusión = new Ataque("Confusión", TipoPokemon.PSIQUICO, 40, EstadoPokemon.CONFUSO, 0.3);
        Ataque psíquico = new Ataque("Psíquico", TipoPokemon.PSIQUICO, 70, EstadoPokemon.NORMAL, 0.1);
        Ataque agua = new Ataque("Hidro-pulso", TipoPokemon.AGUA, 50, EstadoPokemon.NORMAL, 0.2);

        ataques.add(confusión);
        ataques.add(psíquico);
        ataques.add(agua);
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

        int incremento = 5;
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


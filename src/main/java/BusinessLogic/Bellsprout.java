package BusinessLogic;

import java.util.List;
import java.util.ArrayList;

public class Bellsprout extends Pokemon {

    private final List<Ataque> ataques; 

    public Bellsprout(String nombre) {
        super(nombre, TipoPokemon.PLANTA, 50, 75);
        ataques = new ArrayList<>();
        cargarAtaques();
    }

    private void cargarAtaques() {

        Ataque latigazo = new Ataque("Latigazo", TipoPokemon.PLANTA, 40, EstadoPokemon.NORMAL, 0.1);
        Ataque zumbido = new Ataque("Zumbido", TipoPokemon.BICHO, 30, EstadoPokemon.NORMAL, 0.2);
        Ataque acido = new Ataque("Ácido", TipoPokemon.VENENO, 30, EstadoPokemon.VENENO, 0.3);

        ataques.add(latigazo);
        ataques.add(zumbido);
        ataques.add(acido);
    }
    @Override
    public int atacar(int indiceAtaque, Pokemon defensor) {
        if (indiceAtaque < 0 || indiceAtaque >= ataques.size()) {
            System.out.println("Índice de ataque no válido.");
            return 0; 
        }
        int daño = ataques.get(indiceAtaque).calcularDaño(); 
        defensor.recibirDaño(daño);

        return daño; 
    }

    @Override
    public void entrenar() {
        System.out.println(getNombre() + " está entrenando.");
        int incremento = 4;
        int nuevosPuntosAtaque = getPuntosAtaque() + incremento;
        System.out.println(getNombre() + " ha aumentado sus puntos de ataque a " + nuevosPuntosAtaque);
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }
}


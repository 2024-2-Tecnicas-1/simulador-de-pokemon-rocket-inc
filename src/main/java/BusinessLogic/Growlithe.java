package BusinessLogic;

import java.util.List;
import java.util.ArrayList;

public class Growlithe extends Pokemon {

    private final List<Ataque> ataques; 

    public Growlithe(String nombre) {
        super(nombre, TipoPokemon.FUEGO, 55, 70);
        ataques = new ArrayList<>();
        cargarAtaques(); 
    }

    private void cargarAtaques() {
        Ataque llamarada = new Ataque("Llamarada", TipoPokemon.FUEGO, 50, EstadoPokemon.QUEMADO, 0.3);
        Ataque gruñido = new Ataque("Gruñido", TipoPokemon.NORMAL, 0, EstadoPokemon.CONFUSO, 0.2);
        Ataque mordisco = new Ataque("Mordisco", TipoPokemon.FUEGO, 40, EstadoPokemon.NORMAL, 0.1);

        ataques.add(llamarada);
        ataques.add(gruñido);
        ataques.add(mordisco);
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
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }
}





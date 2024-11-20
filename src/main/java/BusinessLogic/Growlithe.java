package BusinessLogic;

public class Growlithe extends Pokemon {

    private final Ataque[] ataques; 

    public Growlithe(String nombre) {
        super(nombre, TipoPokemon.FUEGO, 55, 70);
        ataques = new Ataque[3];
        cargarAtaques(); 
    }

    private void cargarAtaques() {
 
        Ataque llamarada = new Ataque("Llamarada", TipoPokemon.FUEGO, 50, EstadoPokemon.QUEMADO, 0.3);
        Ataque gruñido = new Ataque("Gruñido", TipoPokemon.NORMAL, 0, EstadoPokemon.CONFUSO, 0.2);
        Ataque mordisco = new Ataque("Mordisco", TipoPokemon.FUEGO, 40, EstadoPokemon.NORMAL, 0.1);

        ataques[0] = llamarada;
        ataques[1] = gruñido;
        ataques[2] = mordisco;
    }

    @Override
    public void atacar(int indiceAtaque, Pokemon defensor) {
 
        if (indiceAtaque < 0 || indiceAtaque >= ataques.length) {
            System.out.println("Índice de ataque no válido.");
            return; 
        }

        Ataque ataqueSeleccionado = ataques[indiceAtaque];
        ataqueSeleccionado.aplicarAtaque(defensor);
    }

    @Override
    public void entrenar() {

    }

    public Ataque[] getAtaques() {
        return ataques;
    }
}




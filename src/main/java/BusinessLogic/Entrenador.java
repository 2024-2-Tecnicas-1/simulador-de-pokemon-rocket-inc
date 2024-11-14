package BusinessLogic;

import java.util.ArrayList;
import java.util.List;

public class Entrenador {

    private String nombre;
    private List<Pokemon> pokemones;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
    }

    public void agregarPokemon(Pokemon pokemon) {
        pokemones.add(pokemon);

    }

    public void entrenarPokemon(Pokemon pokemon) {
        if (pokemones.contains(pokemon)) {
            pokemon.entrenar();

        }

    }

    public void mostrarPokemones() {

    }

    public Pokemon prepararBatalla() {
        if (pokemones.isEmpty()) {

        }

        return pokemones.get(0);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pokemon> getPokemones() {
        return pokemones;
    }
}

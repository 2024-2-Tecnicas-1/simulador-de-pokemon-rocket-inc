package BusinessLogic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Entrenador implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private List<Pokemon> pokemones;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
    }

    // Agregar un Pokémon al equipo
    public void agregarPokemon(Pokemon pokemon) {
        if (pokemon != null) {
            pokemones.add(pokemon);
            System.out.println("Pokémon " + pokemon.getNombre() + " agregado al equipo de " + nombre + ".");
        } else {
            System.out.println("No se puede agregar un Pokémon nulo.");
        }
    }

    // Entrenar un Pokémon del equipo
    public void entrenarPokemon(Pokemon pokemon) {
        if (pokemones.contains(pokemon)) {
            pokemon.entrenar(); // Se asume que el método entrenar está definido en la clase Pokemon
            System.out.println("El Pokémon " + pokemon.getNombre() + " ha sido entrenado.");
        } else {
            System.out.println("El Pokémon no pertenece al equipo de " + nombre + ".");
        }
    }

    // Mostrar los Pokémon del equipo
    public void mostrarPokemones() {
        if (pokemones.isEmpty()) {
            System.out.println(nombre + " no tiene Pokémon en su equipo.");
        } else {
            System.out.println("Equipo de " + nombre + ":");
            for (int i = 0; i < pokemones.size(); i++) {
                Pokemon pokemon = pokemones.get(i);
                System.out.println((i + 1) + ". " + pokemon.getNombre() + " (Tipo: " + pokemon.getTipo() + ")");
            }
        }
    }

    // Preparar un Pokémon para la batalla
    public Pokemon prepararBatalla() {
        if (pokemones.isEmpty()) {
            System.out.println(nombre + " no tiene Pokémon disponibles para la batalla.");
            return null;
        }
        return pokemones.get(0); // Devuelve el primer Pokémon como predeterminado
    }

    // Getters y setters
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

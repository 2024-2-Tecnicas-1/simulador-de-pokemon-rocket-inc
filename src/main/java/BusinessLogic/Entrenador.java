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
        System.out.println(pokemon.getNombre() + " se ha agregado al equipo de " + nombre);
    }

    public void entrenarPokemon(Pokemon pokemon) {
        if (pokemones.contains(pokemon)) {
            pokemon.entrenar();
            System.out.println(pokemon.getNombre() + " ha sido entrenado.");
        } else {
            System.out.println("El Pokémon no está en el equipo.");
        }
    }

    
    public void mostrarPokemones() {
        System.out.println("Equipo de " + nombre + ":");
        for (Pokemon pokemon : pokemones) {
            System.out.println("- " + pokemon.getNombre() + " (Salud: " + pokemon.getSalud() + ")");
        }
    }

    
    public Pokemon prepararBatalla() {
        if (pokemones.isEmpty()) {
            System.out.println("El entrenador no tiene Pokémones en su equipo.");
            return null;
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

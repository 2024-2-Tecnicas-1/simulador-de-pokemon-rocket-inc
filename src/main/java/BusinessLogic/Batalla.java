package BusinessLogic;

import java.util.Scanner;

public class Batalla {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Scanner scanner;

    public Batalla(Pokemon pokemon1, Pokemon pokemon2) {
        if (pokemon1 == null || pokemon2 == null) {
            throw new IllegalArgumentException("Ambos Pokémon deben ser válidos y no nulos.");
        }
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarBatalla() {
        System.out.println("Iniciando batalla entre " + pokemon1.getNombre() + " y " + pokemon2.getNombre());
        System.out.println(pokemon1.getNombre() + " tiene " + pokemon1.getVida() + " puntos de salud.");
        System.out.println(pokemon2.getNombre() + " tiene " + pokemon2.getVida() + " puntos de salud.");

        while (pokemon1.getVida() > 0 && pokemon2.getVida() > 0) {
            realizarTurno(pokemon1, pokemon2);
            if (pokemon2.getVida() <= 0) {
                System.out.println(pokemon2.getNombre() + " ha sido derrotado!");
                break;
            }

            realizarTurno(pokemon2, pokemon1);
            if (pokemon1.getVida() <= 0) {
                System.out.println(pokemon1.getNombre() + " ha sido derrotado!");
                break;
            }
        }
    }

    private void realizarTurno(Pokemon atacante, Pokemon defensor) {
        System.out.println(atacante.getNombre() + ", es tu turno. Elige un ataque:");
        for (int i = 0; i < atacante.getAtaques().size(); i++) {
            System.out.println((i + 1) + ". " + atacante.getAtaques().get(i).getNombre());
        }

        int eleccion = scanner.nextInt();
        if (eleccion < 1 || eleccion > atacante.getAtaques().size()) {
            System.out.println("Elección no válida. Elige un ataque válido.");
            return;
        }

        Ataque ataqueElegido = atacante.getAtaques().get(eleccion - 1);
        ataqueElegido.aplicarAtaque(defensor);

        System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre() + " y causa " 
            + ataqueElegido.calcularDaño(defensor.getTipo()) + " puntos de daño.");
        System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getVida() + " puntos de salud.");

        if (defensor.tieneEstado(EstadoPokemon.VENENO)) {
            int dañoPorVeneno = defensor.getEstadoActual().getDañoPorTurno();
            defensor.recibirDaño(dañoPorVeneno);
            System.out.println(defensor.getNombre() + " recibe " + dañoPorVeneno + " puntos de daño por veneno.");
        }

        if (defensor.tieneEstado(EstadoPokemon.QUEMADO)) {
            int dañoPorQuemadura = defensor.getEstadoActual().getDañoPorTurno();
            defensor.recibirDaño(dañoPorQuemadura);
            System.out.println(defensor.getNombre() + " recibe " + dañoPorQuemadura + " puntos de daño por quemadura.");
        }
        defensor.mostrarEfectoDelEstado();
    }
}




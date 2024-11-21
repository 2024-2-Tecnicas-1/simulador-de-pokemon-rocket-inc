package Consola;

import java.util.Scanner;
import Persistence.FileConect;
import Persistence.FileControl;
import BusinessLogic.Entrenador;
import BusinessLogic.Pokemon;
import BusinessLogic.Batalla;
import BusinessLogic.Entrenador;
import BusinessLogic.Growlithe;
import BusinessLogic.Farfetchd;
import BusinessLogic.Bellsprout;
import BusinessLogic.Exeggcute;
import BusinessLogic.Hitmonlee;
import BusinessLogic.Onix;
import BusinessLogic.Psyduck;
import BusinessLogic.Voltorb;
import BusinessLogic.Zubat;
import BusinessLogic.Tentacool;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    private static Scanner sc = new Scanner(System.in);
    private static List<Entrenador> entrenadores = new ArrayList<>();
    private static List<Pokemon> pokemones = new ArrayList<>();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    gestionarEntrenadores();
                    break;
                case 2:
                    gestionarPokemon();
                    break;
                case 3:
                    iniciarBatalla();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo del simulador");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("Batallas Pokémon");
        System.out.print("Elige una opción: ");
        System.out.println("1. Gestionar Entrenadores");
        System.out.println("2. Gestionar Pokémones");
        System.out.println("3. Iniciar Batalla");
        System.out.println("4. Salir");

    }

    private static int leerOpcion() {
        System.out.print("Introduce una opción: ");
        if (sc.hasNextInt()) {
            return sc.nextInt();
        } else {
            sc.next();
            return 0;
        }
    }

    private static void gestionarEntrenadores() {
        boolean regresar = false;

        while (!regresar) {
            mostrarSubmenuEntrenadores();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    registrarEntrenador();
                    break;
                case 2:
                    verListaEntrenadores();
                    break;
                case 3:
                    seleccionarEntrenador();
                    break;
                case 4:
                    regresar = true;
                    break;
                default:
                    System.out.println("Intenta de nuevo");
            }
        }
    }

    private static void mostrarSubmenuEntrenadores() {
        System.out.println("\nGestionar Entrenadores");
        System.out.println("1. Registrar nuevo entrenador");
        System.out.println("2. Ver lista de entrenadores");
        System.out.println("3. Seleccionar un entrenador");
        System.out.println("4. Volver al menú principal");
        System.out.print("Elige una opción: ");
    }

    private static void registrarEntrenador() {
        System.out.print("Introduce el nombre del entrenador: ");
        String nombre = sc.nextLine();

        System.out.println("Entrenador " + nombre + " registrado exitosamente.");
    }

    private static void verListaEntrenadores() {
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
        } else {
            System.out.println("Lista de entrenadores:");
            for (int i = 0; i < entrenadores.size(); i++) {
                System.out.println((i + 1) + ". " + entrenadores.get(i).getNombre());
            }
        }
    }
    private static void verListaPokemon() {
    if (pokemones.isEmpty()) {
        System.out.println("No hay Pokémones registrados.");
    } else {
        System.out.println("Lista de Pokémones:");
        for (int i = 0; i < pokemones.size(); i++) {
            Pokemon pokemon = pokemones.get(i);
            if (pokemon != null) {
                System.out.println((i + 1) + ". " + pokemon.getNombre());
            } else {
                System.out.println((i + 1) + "");
            }
        }
    }
}

    private static void seleccionarEntrenador() {

        System.out.println("Selecciona un entrenador");
    }

    private static void gestionarPokemon() {
        boolean regresar = false;

        while (!regresar) {
            mostrarSubmenuPokemon();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    verListaPokemon();
                    break;
                case 2:
                    registrarPokemon();
                    break;
                case 3:
                    regresar = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void mostrarSubmenuPokemon() {
        System.out.println("\nGestionar Pokémones");
        System.out.println("1. Ver todos los Pokémones registrados");
        System.out.println("2. Registrar nuevo Pokémon");
        System.out.println("3. Volver al menú principal");
        System.out.print("Elige una opción: ");
    }

    

    private static void registrarPokemon() {
    boolean regresar = false;

    while (!regresar) {
        System.out.println("\nAgregar Pokemones:");
        System.out.println("1) Growlithe");
        System.out.println("2) Psyduck");
        System.out.println("3) Zubat");
        System.out.println("4) Bellsprout");
        System.out.println("5) Voltorb");
        System.out.println("6) Exeggcute");
        System.out.println("7) Onix");
        System.out.println("8) Farfetch'd");
        System.out.println("9) Hitmonlee");
        System.out.println("10) Tentacool");
        System.out.println("11) Regresar al menú anterior");
        System.out.print("Elige una opción: ");

        int opcion = leerOpcion();

        Pokemon nuevoPokemon = null;

        switch (opcion) {
            case 1:
                nuevoPokemon = new Growlithe("Growlithe");
                break;
            case 2:
                nuevoPokemon = new Psyduck("Psyduck");
                break;
            case 3:
                nuevoPokemon = new Zubat("Zubat");
                break;
            case 4:
                nuevoPokemon = new Bellsprout("Bellsprout");
                break;
            case 5:
                nuevoPokemon = new Voltorb("Voltorb");
                break;
            case 6:
                nuevoPokemon = new Exeggcute("Exeggcute");
                break;
            case 7:
                nuevoPokemon = new Onix("Onix");
                break;
            case 8:
                nuevoPokemon = new Farfetchd("Farfetch'd");
                break;
            case 9:
                nuevoPokemon = new Hitmonlee("Hitmonlee");
                break;
            case 10:
                nuevoPokemon = new Tentacool("Tentacool");
                break;
            case 11:
                regresar = true;
                break;
            default:
                System.out.println("Opción inválida. Intenta de nuevo.");
        }

        if (nuevoPokemon != null) {
            pokemones.add(nuevoPokemon);
            System.out.println("¡" + nuevoPokemon.getNombre() + " registrado exitosamente!");
        }
    }
}


    private static void iniciarBatalla() {
        System.out.println("Iniciando batalla!");
    }
}

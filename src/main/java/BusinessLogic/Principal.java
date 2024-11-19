package BusinessLogic;

import java.util.Scanner;

public class Principal {

    private static Scanner sc = new Scanner(System.in);

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

        System.out.println("Mostrando entrenadores");
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

    private static void verListaPokemon() {

        System.out.println("Mostrando lista de Pokémon");
    }

    private static void registrarPokemon() {
        System.out.print("Introduce el nombre del Pokémon: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce el tipo del Pokémon: ");
        String tipo = sc.nextLine();

        System.out.println("Pokémon " + nombre + " de tipo " + tipo + " ha sidoregistrado ");
    }

    private static void iniciarBatalla() {
        System.out.println("Iniciando batalla!");
    }
}

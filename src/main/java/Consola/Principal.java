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
        System.out.println("\nAgregar Pokemones:");
        System.out.println("\n1) Growlithe");
        System.out.println("\n2) Psyduck");
        System.out.println("\n3) Zubat");
        System.out.println("\n4) Bellsprout");
        System.out.println("\n5) Voltorb");
        System.out.println("\n6) Exeggcute");
        System.out.println("\n7) Onix");
        System.out.println("\n8) Farfetcht'd");
        System.out.println("\n9) Hitmonlee");
        System.out.println("\n10) Tentacool");

        boolean regresar = false;

        while (!regresar) {
            mostrarSubmenuPokemon();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1: {
                    String nombre = null;
                    Growlithe growlithe = new Growlithe(nombre);
                    break;
                }
                case 2: {
                    String nombre = null;
                    Psyduck psyduck = new Psyduck(nombre);
                    break;
                }
                case 3: {
                    String nombre = null;
                    Zubat zubat = new Zubat(nombre);
                    break;
                }
                case 4: {
                    String nombre = null;
                    Bellsprout bellsprout = new Bellsprout(nombre);
                    break;
                }
                case 5: {
                    String nombre = null;
                    Voltorb voltorb = new Voltorb(nombre);
                    break;
                }
                case 6: {
                    String nombre = null;
                    Exeggcute exeggcute = new Exeggcute(nombre);
                    break;
                }
                case 7: {
                    String nombre = null;
                    Onix onix = new Onix(nombre);
                    break;
                }
                case 8: {
                    String nombre = null;
                    Farfetchd farfetchd = new Farfetchd(nombre);
                    break;
                }
                case 9: {
                    String nombre = null;
                    Hitmonlee hitmonlee = new Hitmonlee(nombre);
                    break;
                }
                case 10: {
                    String nombre = null;
                    Tentacool tentacool = new Tentacool(nombre);
                    break;
                }
                case 11: {
                    regresar = true;
                    break;
                }
                default: {
                    System.out.println("Opción inválida. Intenta de nuevo.");
                    break;
                }
            }
        }
    }

    private static void iniciarBatalla() {
        System.out.println("Iniciando batalla!");
    }
}

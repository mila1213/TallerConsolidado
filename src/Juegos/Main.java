package Juegos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Juego> juegos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n----- MENÚ -----");
            System.out.println("1. Registrar Mario Bros");
            System.out.println("2. Registrar Carrera de Vehículos");
            System.out.println("3. Mostrar todos");
            System.out.println("4. Buscar por nombre");
            System.out.println("5. Filtrar por tipo");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            // Validar opcion
            while (!sc.hasNextInt()) {
                System.out.print("Debes ingresar un número: ");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    try {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Nivel (entero): ");
                        while (!sc.hasNextInt()) {
                            System.out.print("Debes ingresar un número entero: ");
                            sc.next();
                        }
                        int nivel = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Descripción: ");
                        String descripcion = sc.nextLine();

                        System.out.print("Personaje: ");
                        String personaje = sc.nextLine();

                        juegos.add(new MarioBros(nombre, nivel, descripcion, personaje));
                        System.out.println("Mario Bros registrado.");
                    } catch (JuegoInvalidoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2: // Registrar Carreras
                    try {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Nivel (entero): ");
                        while (!sc.hasNextInt()) {
                            System.out.print("Debes ingresar un número entero: ");
                            sc.next();
                        }
                        int nivel = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Descripción: ");
                        String descripcion = sc.nextLine();

                        System.out.print("Tipo de vehículo: ");
                        String tipo = sc.nextLine();

                        juegos.add(new CarreraVehiculos(nombre, nivel, descripcion, tipo));
                        System.out.println("Juego de carreras registrado.");
                    } catch (JuegoInvalidoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    if (juegos.isEmpty()) {
                        System.out.println("No hay juegos registrados.");
                    } else {
                        for (Juego j : juegos) {
                            j.mostrarDetalles();
                        }
                    }
                    break;

                case 4: // Buscar por nombre
                    System.out.print("Nombre a buscar: ");
                    String buscar = sc.nextLine();
                    boolean encontrado = false;

                    for (Juego j : juegos) {
                        if (j.getNombre().equalsIgnoreCase(buscar)) {
                            j.mostrarDetalles();
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró ese juego.");
                    }
                    break;

                case 5:
                    System.out.println("1. Mario Bros");
                    System.out.println("2. Carreras");
                    System.out.print("Tipo: ");

                    int tipo;
                    while (!sc.hasNextInt()) {
                        System.out.print("Debes ingresar un número: ");
                        sc.next();
                    }
                    tipo = sc.nextInt();

                    boolean hay = false;

                    for (Juego j : juegos) {
                        if (tipo == 1 && j instanceof MarioBros) {
                            j.mostrarDetalles();
                            hay = true;
                        } else if (tipo == 2 && j instanceof CarreraVehiculos) {
                            j.mostrarDetalles();
                            hay = true;
                        }
                    }

                    if (!hay) {
                        System.out.println("No hay juegos de ese tipo.");
                    }

                    break;

                case 6:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);


    }
}

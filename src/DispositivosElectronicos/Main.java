package DispositivosElectronicos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Dispositivo> lista = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n--- MENU DISPOSITIVOS -- ");
            System.out.println("1. Registrar Laptop");
            System.out.println("2. Registrar Teléfono");
            System.out.println("3. Mostrar dispositivos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    try {
                        System.out.print("Marca: ");
                        String marca = sc.nextLine();
                        System.out.print("Modelo: ");
                        String modelo = sc.nextLine();
                        System.out.print("Precio: ");
                        double precio = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("RAM (GB): ");
                        int ram = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Almacenamiento (GB): ");
                        int almacenamiento = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Procesador : ");
                        String procesador = sc.nextLine();
                        sc.nextLine();
                        lista.add(new Laptop(marca, modelo, precio, ram, almacenamiento,procesador));
                        System.out.println("Laptop registrada correctamente.");

                    } catch (DatoInvalidoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Marca: ");
                        String marca = sc.nextLine();

                        System.out.print("Modelo: ");
                        String modelo = sc.nextLine();

                        System.out.print("Precio: ");
                        double precio = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Sistema Operativo: ");
                        String sistema = sc.nextLine();

                        lista.add(new Telefono(marca, modelo, precio, sistema));
                        System.out.println("Teléfono registrado correctamente.");

                    } catch (DatoInvalidoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("\n--- LISTA DE DISPOSITIVOS ---\n");
                    if (lista.isEmpty()) {
                        System.out.println("No hay dispositivos registrados.");
                    } else {
                        for (Dispositivo d : lista) {
                            d.mostrarInfo(); // POLIMORFISMO
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

    }
}



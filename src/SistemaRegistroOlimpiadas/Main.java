package SistemaRegistroOlimpiadas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Olimpiada olimpiada = new Olimpiada("Olimpiadas Nacionales");

        while (true) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar Evento");
            System.out.println("2. Registrar Atleta en un Evento");
            System.out.println("3. Registrar Equipo en un Evento");
            System.out.println("4. Listar Eventos");
            System.out.println("5. Listar Atletas");
            System.out.println("6. Listar Equipos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion;
            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                sc.nextLine();
                continue;
            }

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Nombre del evento: ");
                        String nombreEvento = sc.nextLine();
                        olimpiada.agregarEvento(new Evento(nombreEvento));
                        System.out.println("Evento registrado.");
                        break;

                    case 2:
                        if (olimpiada.getEventos().isEmpty()) {
                            System.out.println("Primero debe registrar un evento.");
                            break;
                        }
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        if (!nombre.matches("[a-zA-Z ]+")) {
                            throw new ExcepcionDatosInvalidos("El nombre debe contener solo letras.");
                        }

                        System.out.print("Código: ");
                        String codigo = sc.nextLine();

                        System.out.print("Cédula: ");
                        String cedulaStr = sc.nextLine();
                        if (cedulaStr.length() != 10) {
                            throw new ExcepcionDatosInvalidos("La cédula debe tener exactamente 10 dígitos.");
                        }
                        int cedula = Integer.parseInt(cedulaStr);

                        System.out.print("Género: ");
                        String genero = sc.nextLine();

                        System.out.print("Edad: ");
                        int edad;
                        try {
                            edad = sc.nextInt();
                            sc.nextLine();
                        } catch (InputMismatchException e) {
                            sc.nextLine();
                            throw new ExcepcionDatosInvalidos("La edad debe ser un número válido.");
                        }
                        if (edad <= 0) {
                            throw new ExcepcionDatosInvalidos("La edad debe ser mayor a 0.");
                        }

                        System.out.print("Disciplina: ");
                        String disciplina = sc.nextLine();

                        Atleta atleta = new Atleta(nombre, codigo, cedula, genero, edad, disciplina);
                        olimpiada.getEventos().get(0).agregarParticipante(atleta);
                        System.out.println("Atleta registrado: " + atleta.MostrarInformacion());
                        break;

                    case 3:
                        if (olimpiada.getEventos().isEmpty()) {
                            System.out.println("Primero debe registrar un evento.");
                            break;
                        }
                        System.out.print("Nombre del equipo: ");
                        String nomEquipo = sc.nextLine();
                        Equipo equipo = new Equipo(nomEquipo, "EQ01", 0, "N/A", 0);
                        olimpiada.getEventos().get(0).agregarParticipante(equipo);
                        System.out.println("Equipo registrado: " + equipo.MostrarInformacion());
                        break;

                    case 4:
                        olimpiada.listarEventos();
                        for (Evento e : olimpiada.getEventos()) {
                            e.listarParticipantes();
                        }
                        break;

                    case 5:
                        for (Evento e : olimpiada.getEventos()) {
                            System.out.println("\nAtletas en el evento " + e + ":");
                            for (Participante p : e.getParticipantes()) {
                                if (p instanceof Atleta) {
                                    System.out.println(p.MostrarInformacion());
                                }
                            }
                        }
                        break;

                    case 6:
                        for (Evento e : olimpiada.getEventos()) {
                            System.out.println("\nEquipos en el evento " + e + ":");
                            for (Participante p : e.getParticipantes()) {
                                if (p instanceof Equipo) {
                                    System.out.println(p.MostrarInformacion());
                                }
                            }
                        }
                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        return;

                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (ExcepcionDatosInvalidos e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

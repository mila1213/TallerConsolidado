package EleccionReinaQuito;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Concurso concurso = new Concurso();
        int opcion = 0;
        int idAuto = 1;
        int idVotoAuto = 1;

        while (opcion != 6) {
            System.out.println("\n------ ELECCIÓN REINA DE QUITO -----");
            System.out.println("1. Registrar Candidata Estudiante");
            System.out.println("2. Registrar Candidata Profesional");
            System.out.println("3. Listar Candidatas");
            System.out.println("4. Registrar Voto");
            System.out.println("5. Mostrar Ganadora");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("\n-- Registrar Estudiante --");

                    try {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Edad: ");
                        int edad = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Distrito: ");
                        String distrito = sc.nextLine();

                        System.out.print("Puntaje del Jurado (0-100): ");
                        double puntaje = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Universidad: ");
                        String uni = sc.nextLine();

                        System.out.print("Carrera: ");
                        String carrera = sc.nextLine();

                        CandidataEstudiante ce = new CandidataEstudiante(
                                idAuto, nombre, edad, distrito, puntaje, uni, carrera
                        );

                        concurso.registrarCandidata(ce);
                        idAuto++;

                    } catch (DatoInvalidoException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\n-- Registrar Profesional --");

                    try {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Edad: ");
                        int edad = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Distrito: ");
                        String distrito = sc.nextLine();

                        System.out.print("Puntaje del Jurado (0-100): ");
                        double puntaje = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Profesión: ");
                        String prof = sc.nextLine();

                        System.out.print("Años de experiencia: ");
                        int exp = sc.nextInt();
                        sc.nextLine();

                        CandidataProfesional cp = new CandidataProfesional(
                                idAuto, nombre, edad, distrito, puntaje, prof, exp
                        );

                        concurso.registrarCandidata(cp);
                        idAuto++;

                    } catch (DatoInvalidoException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("\n-- Lista de Candidatas --");
                    concurso.listarCandidatas();
                    break;

                case 4:
                    System.out.println("\n-- Registrar Voto --");

                    System.out.print("Ingrese ID de la candidata: ");
                    int idCand = sc.nextInt();
                    sc.nextLine();

                    Candidata encontrada = concurso.buscarPorId(idCand);

                    if (encontrada == null) {
                        System.out.println("La candidata NO existe.");
                    } else {
                        Voto v = new Voto(idVotoAuto, idCand);
                        concurso.votar(idCand);
                        idVotoAuto++;
                    }
                    break;

                case 5:
                    System.out.println("\n-- Ganadora --");
                    Candidata ganadora = concurso.obtenerGanadora();

                    if (ganadora != null) {
                        System.out.println("La ganadora es:");
                        ganadora.mostrarDetalles();
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}

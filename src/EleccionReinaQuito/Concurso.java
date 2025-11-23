package EleccionReinaQuito;
import java.util.ArrayList;

public class Concurso {

    private ArrayList<Candidata> listaCandidatas;
    private ArrayList<Voto> votos;


    private int idVotoAuto = 1;

    public Concurso() {
        listaCandidatas = new ArrayList<>();
        votos = new ArrayList<>();
    }


    public void registrarCandidata(Candidata c) {
        listaCandidatas.add(c);
        System.out.println("Candidata registrada con éxito.\n");
    }

    public void listarCandidatas() {
        if (listaCandidatas.isEmpty()) {
            System.out.println("No hay candidatas registradas.");
            return;
        }
        for (Candidata c : listaCandidatas) {
            c.mostrarDetalles();
            System.out.println("---------------------");
        }
    }

    public Candidata buscarPorId(int id) {
        for (Candidata c : listaCandidatas) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }


    public Candidata buscarPorNombre(String nombre) {
        for (Candidata c : listaCandidatas) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }


    public void votar(int idCandidata) {
        Candidata candidata = buscarPorId(idCandidata);

        if (candidata == null) {
            System.out.println("La candidata no existe.");
            return;
        }

        // Constructor correcto: (idVoto, idCandidata)
        Voto v = new Voto(idVotoAuto, idCandidata);
        idVotoAuto++;

        votos.add(v);
        System.out.println("Voto registrado.");
    }

    // Mostrar cantidad de votos por cada candidata (método simple)
    public void mostrarConteoVotos() {
        for (Candidata c : listaCandidatas) {
            int contador = 0;

            for (Voto v : votos) {
                if (v.getIdCandidata() == c.getId()) {
                    contador++;
                }
            }

            System.out.println(c.getNombre() + " tiene " + contador + " votos.");
        }
    }

    public Candidata obtenerGanadora() {

        if (votos.isEmpty()) {
            System.out.println("No hay votos registrados.");
            return null;
        }

        Candidata ganadora = null;
        int maxVotos = -1;

        for (Candidata c : listaCandidatas) {

            int contador = 0;
            for (Voto v : votos) {
                if (v.getIdCandidata() == c.getId()) {
                    contador++;
                }
            }

            if (contador > maxVotos) {
                maxVotos = contador;
                ganadora = c;
            }

            else if (contador == maxVotos && ganadora != null) {
                if (c.getPuntajeJurado() > ganadora.getPuntajeJurado()) {
                    ganadora = c;
                }
            }
        }

        return ganadora;
    }
}

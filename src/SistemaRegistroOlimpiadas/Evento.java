package SistemaRegistroOlimpiadas;

import java.util.ArrayList;

public class Evento {
    private String nombre;
    private ArrayList<Participante> participantes;

    public Evento(String nombre) {
        this.nombre = nombre;
        this.participantes = new ArrayList<>();
    }

    public void agregarParticipante(Participante p) {
        participantes.add(p);
    }

    public void listarParticipantes() {
        System.out.println("Participantes en el evento " + nombre + ":");
        for (Participante p : participantes) {
            System.out.println(p.MostrarInformacion());
        }
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

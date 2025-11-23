package SistemaRegistroOlimpiadas;

import java.util.ArrayList;

public class Olimpiada {
    private String nombre;
    private ArrayList<Evento> eventos;

    public Olimpiada(String nombre) {
        this.nombre = nombre;
        this.eventos = new ArrayList<>();
    }

    public void agregarEvento(Evento e) {
        eventos.add(e);
    }

    // 🔑 ESTE MÉTODO ES EL QUE TE FALTA
    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void listarEventos() {
        System.out.println("Eventos en la Olimpiada " + nombre + ":");
        for (Evento e : eventos) {
            System.out.println("- " + e);
        }
    }
}

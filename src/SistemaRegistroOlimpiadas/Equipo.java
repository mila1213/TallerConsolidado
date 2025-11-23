package SistemaRegistroOlimpiadas;
import java.util.ArrayList;

public class Equipo extends Participante {
    private ArrayList<Atleta> integrantes;

    public Equipo(String nombre, String codigo, int cedula, String genero, int edad) {
        super(nombre, codigo, cedula, genero, edad);
        this.integrantes = new ArrayList<>();
    }

    public void agregarIntegrante(Atleta atleta) {
        integrantes.add(atleta);
    }

    @Override
    public String MostrarInformacion() {
        return "Equipo: " + nombre + "\nCódigo: " + codigo +
                "\nIntegrantes: " + integrantes.size();
    }
}


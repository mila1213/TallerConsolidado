package SistemaRegistroOlimpiadas;

public class Atleta extends Participante {
    private String disciplina;

    public Atleta(String nombre, String codigo, int cedula, String genero, int edad, String disciplina) {
        super(nombre, codigo, cedula, genero, edad);
        this.disciplina = disciplina;
    }

    @Override
    public String MostrarInformacion() {
        return "Atleta: " + nombre + "\nCódigo: " + codigo +
                "\nCédula: " + cedula + "\nGénero: " + genero +
                "\nEdad: " + edad + "\nDisciplina: " + disciplina;
    }
}

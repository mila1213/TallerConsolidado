package EleccionReinaQuito;

public class CandidataProfesional extends Candidata {
    private String profesion;
    private int anosExperiencia;

    public CandidataProfesional(int id, String nombre, int edad, String distrito, double puntajeJurado,
                                String profesion, int anosExperiencia) throws DatoInvalidoException {
        super(id, nombre, edad, distrito, puntajeJurado);
        if (profesion == null || profesion.trim().isEmpty()) throw new DatoInvalidoException("Profesión no puede estar vacía.");
        if (anosExperiencia < 0) throw new DatoInvalidoException("Años de experiencia no puede ser negativo.");
        this.profesion = profesion;
        this.anosExperiencia = anosExperiencia;
    }

    public String getProfesion() {
        return profesion;
    }
    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("[Profesional] " + toString() + " \nProfesión: " + profesion + "\nAños experiencia: " + anosExperiencia);
    }
}


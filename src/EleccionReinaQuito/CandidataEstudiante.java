package EleccionReinaQuito;

public class CandidataEstudiante extends Candidata {
    private String universidad;
    private String carrera;

    public CandidataEstudiante(int id, String nombre, int edad, String distrito, double puntajeJurado,
                               String universidad, String carrera) throws DatoInvalidoException {
        super(id, nombre, edad, distrito, puntajeJurado);
        if (universidad == null || universidad.trim().isEmpty()) throw new DatoInvalidoException("Universidad no puede estar vacía.");
        if (carrera == null || carrera.trim().isEmpty()) throw new DatoInvalidoException("Carrera no puede estar vacía.");
        this.universidad = universidad;
        this.carrera = carrera;
    }

    public String getUniversidad() {
        return universidad; }

    public String getCarrera() {
        return carrera; }

    @Override
    public void mostrarDetalles() {
        System.out.println("[Estudiante] " + toString() +
                String.format(" | Universidad: %s | Carrera: %s", universidad, carrera));
    }
}


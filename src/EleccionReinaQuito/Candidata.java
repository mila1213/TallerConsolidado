package EleccionReinaQuito;

// Candidata.java
public abstract class Candidata {
    protected int id;
    protected String nombre;
    protected int edad;
    protected String distrito;
    protected double puntajeJurado;

    public Candidata(int id, String nombre, int edad, String distrito, double puntajeJurado) throws DatoInvalidoException {
        validarDatos(nombre, edad, distrito, puntajeJurado);
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.distrito = distrito;
        this.puntajeJurado = puntajeJurado;
    }

    private void validarDatos(String nombre, int edad, String distrito, double puntajeJurado) throws DatoInvalidoException {
        if (nombre == null || nombre.trim().isEmpty())
            throw new DatoInvalidoException("Nombre no puede estar vacío.");
        if (distrito == null || distrito.trim().isEmpty())
            throw new DatoInvalidoException("Distrito no puede estar vacío.");
        if (edad < 16)
            throw new DatoInvalidoException("Edad inválida. Debe ser >= 16.");
        if (puntajeJurado < 0 || puntajeJurado > 100)
            throw new DatoInvalidoException("Puntaje jurado debe estar entre 0 y 100.");
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getDistrito() { return distrito; }
    public double getPuntajeJurado() { return puntajeJurado; }

    public void setNombre(String nombre) throws DatoInvalidoException {
        if (nombre == null || nombre.trim().isEmpty()) throw new DatoInvalidoException("Nombre no puede ser vacío.");
        this.nombre = nombre;
    }
    public void setEdad(int edad) throws DatoInvalidoException {
        if (edad < 16) throw new DatoInvalidoException("Edad inválida. Debe ser >= 16.");
        this.edad = edad;
    }
    public void setDistrito(String distrito) throws DatoInvalidoException {
        if (distrito == null || distrito.trim().isEmpty()) throw new DatoInvalidoException("Distrito no puede estar vacío.");
        this.distrito = distrito;
    }
    public void setPuntajeJurado(double puntajeJurado) throws DatoInvalidoException {
        if (puntajeJurado < 0 || puntajeJurado > 100) throw new DatoInvalidoException("Puntaje jurado debe estar entre 0 y 100.");
        this.puntajeJurado = puntajeJurado;
    }

    public abstract void mostrarDetalles();

    @Override
    public String toString() {
        return String.format("ID: %d | Nombre: %s | Edad: %d | Distrito: %s | Puntaje Jurado: %.2f",
                id, nombre, edad, distrito, puntajeJurado);
    }
}


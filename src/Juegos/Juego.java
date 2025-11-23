package Juegos;

public abstract class Juego {
    protected String nombre;
    protected int nivel;
    protected String descripcion;

    public Juego(String nombre, int nivel, String descripcion) throws JuegoInvalidoException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new JuegoInvalidoException("El nombre no puede estar vacío.");
        }
        if (nivel <= 0) {
            throw new JuegoInvalidoException("El nivel debe ser un entero positivo.");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new JuegoInvalidoException("La descripción no puede estar vacía.");
        }

        this.nombre = nombre.trim();
        this.nivel = nivel;
        this.descripcion = descripcion.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public abstract void mostrarDetalles();
}

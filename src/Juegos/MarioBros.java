package Juegos;

public class MarioBros extends Juego {
    private String personaje;

    public MarioBros(String nombre, int nivel, String descripcion, String personaje) throws JuegoInvalidoException {
        super(nombre, nivel, descripcion);

        if (personaje == null || personaje.trim().isEmpty()) {
            throw new JuegoInvalidoException("El personaje no puede estar vacío.");
        }
        this.personaje = personaje.trim();
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("=== Mario Bros ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Personaje: " + personaje);
    }
}

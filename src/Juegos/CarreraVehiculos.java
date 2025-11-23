package Juegos;

public class CarreraVehiculos extends Juego {
    private String tipoVehiculo;

    public CarreraVehiculos(String nombre, int nivel, String descripcion, String tipoVehiculo) throws JuegoInvalidoException {
        super(nombre, nivel, descripcion);

        if (tipoVehiculo == null || tipoVehiculo.trim().isEmpty()) {
            throw new JuegoInvalidoException("El tipo de vehículo no puede estar vacío.");
        }
        this.tipoVehiculo = tipoVehiculo.trim();
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("=== Carrera de Vehículos ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Tipo de vehículo: " + tipoVehiculo);
    }
}

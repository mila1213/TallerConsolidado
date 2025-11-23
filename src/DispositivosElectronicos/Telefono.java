package DispositivosElectronicos;

public class Telefono extends Dispositivo {
    private String sistema;

    public Telefono(String marca, String modelo, double precio, String sistema) throws DatoInvalidoException {
        super(marca, modelo, precio);
        this.sistema = sistema;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("--- Teléfono ----");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("Sistema: " + sistema);
        System.out.println();
    }
}


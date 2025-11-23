package DispositivosElectronicos;

public class Laptop extends Dispositivo {
    private int ram;
    private int almacenamiento;
    private String procesador;
    public Laptop(String marca, String modelo, double precio, int ram, int almacenamento,String procesador) throws DatoInvalidoException {
        super(marca, modelo, precio);
        this.ram = ram;
        this.almacenamiento = almacenamento;
        this.procesador = procesador;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("--- Laptop ---");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("RAM: " + ram + "GB");
        System.out.println("Almacenamiento: " + almacenamiento + "GB");
        System.out.println("Procesador : " + procesador);
    }
}
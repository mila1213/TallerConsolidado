package SistemaRegistroOlimpiadas;

public abstract class Participante {
    protected String nombre;
    protected String codigo;
    protected int cedula;
    protected String genero;
    protected int edad;

    // Constructor
    public Participante(String nombre, String codigo, int cedula, String genero, int edad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cedula = cedula;
        this.genero = genero;
        this.edad = edad;
    }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public int getCedula() { return cedula; }
    public void setCedula(int cedula) { this.cedula = cedula; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) {
        if (edad > 0) this.edad = edad;
    }

    public abstract String MostrarInformacion();
}

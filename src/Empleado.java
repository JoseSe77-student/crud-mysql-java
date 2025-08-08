public class Empleado {
    private int id;
    private String nombre;
    private int edad;
    private String genero;
    private double salario;

    public Empleado(int id, String nombre, int edad, String genero, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.salario = salario;
    }

    public Empleado(String nombre, int edad, String genero, double salario) {
        this(0, nombre, edad, genero, salario);
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public String getGenero() {
        return genero;
    }
    public double getSalario() {
        return salario;
    }


    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", salario=" + salario +
                '}';
    }

}

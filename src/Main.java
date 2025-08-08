import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        
        int op = 0;
        EmpleadoDAO dao = new EmpleadoDAO();
        List<Empleado> empleados = dao.listar();

        System.out.println("Seleccione una opción:");
        System.out.println("1. Insertar Empleado"); 
        System.out.println("2. Listar Empleados");
        System.out.println("3. Actualizar Empleado");
        System.out.println("4. Eliminar Empleado");
        Scanner scanner = new Scanner(System.in);
        op = scanner.nextInt();
        scanner.close();
        
        switch (op){

            case 1:
                // CREATE
                dao.insertar(new Empleado("Manuel", 37, "Masculino", 5123.0));
                dao.insertar(new Empleado("Ana", 25, "Femenino", 6000.0));
                empleados = dao.listar();
                System.out.println("Lista de empleados:");
                empleados.forEach(System.out::println);
                break;

            case 2:
                // READ
                empleados = dao.listar();
                System.out.println("Lista de empleados:");
                empleados.forEach(System.out::println);
                break;

            case 3:
                // UPDATE
                dao.actualizar(1, 5500.0);
                empleados = dao.listar();
                System.out.println("Lista de empleados:");
                empleados.forEach(System.out::println);
                break;

            case 4:
                // DELETE
                dao.eliminar(1);
                dao.eliminar(3);
                dao.eliminar(4);
                empleados = dao.listar();
                System.out.println("Lista de empleados:");
                empleados.forEach(System.out::println);
                break;

        }
    }
}

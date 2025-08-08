import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    public void insertar(Empleado empleado) {
        String sql = "INSERT INTO empleado (nombre, edad, genero, salario) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, empleado.getNombre());
            stmt.setInt(2, empleado.getEdad());
            stmt.setString(3, empleado.getGenero());
            stmt.setDouble(4, empleado.getSalario());
            stmt.executeUpdate();
            System.out.println("Empleado insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Empleado> listar() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleado";
        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                empleados.add(new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("genero"),
                    rs.getDouble("salario")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public void actualizar(int id, double nuevoSalario) {
        String sql = "UPDATE empleado SET salario = ? WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, nuevoSalario);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Empleado actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM empleado WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Empleado eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

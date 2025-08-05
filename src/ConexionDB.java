import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                Config.get("db.url"),
                Config.get("db.user"),
                Config.get("db.password")
            );
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }
}

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final String CONFIG_FILE = "db_config.properties";
    private static Properties props = new Properties();

    static {
        try {
            props.load(new FileInputStream(CONFIG_FILE));
        } catch (IOException e) {
            System.out.println("No se pudo leer la configuración: " + e.getMessage());
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}

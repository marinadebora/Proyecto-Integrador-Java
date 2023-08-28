package Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConfig {
    static String dbDriver = "org.h2.Driver";
    static String url = "jdbc:h2:C:\\Users\\PiuchyHP\\Desktop\\CursoJava\\Proyecto-Integrador\\dataBase\\dataBase"; // URL de conexión a la base de datos H2
    static String username = "debora"; // Nombre de usuario de la base de datos
    static String password = ""; // Contraseña de la base de datos

    public static Connection getDBConnection() {
        Connection connection = null;
        try {
            // Establecer la conexión con la base de datos
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return  connection;
    }

}

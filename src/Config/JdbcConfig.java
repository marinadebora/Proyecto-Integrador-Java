package Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConfig {
    static String dbDriver = "org.h2.Driver";
    static String url = "jdbc:h2:~/dataBase";
    static String username = "debora";
    static String password = "";

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

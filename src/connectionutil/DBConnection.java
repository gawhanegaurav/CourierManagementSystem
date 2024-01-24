// Task 9: Database Interaction

package connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    // Your database connection properties
    private static final String DB_PROPERTIES_FILE = "db.properties";
    private static final String DB_URL_PROPERTY = "db.url";
    private static final String DB_USER_PROPERTY = "db.user";
    private static final String DB_PASSWORD_PROPERTY = "db.password";

    private static Connection connection;

    // Private constructor to prevent instantiation
    private DBConnection() {
    }

    // Static method to get a database connection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load database properties from the file
                Properties properties = new Properties();
                properties.load(DBConnection.class.getClassLoader().getResourceAsStream(DB_PROPERTIES_FILE));

                // Establish a database connection
                connection = DriverManager.getConnection(
                        properties.getProperty(DB_URL_PROPERTY),
                        properties.getProperty(DB_USER_PROPERTY),
                        properties.getProperty(DB_PASSWORD_PROPERTY)
                );
            } catch (SQLException | IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error connecting to the database");
            }
        }
        return connection;
    }
}

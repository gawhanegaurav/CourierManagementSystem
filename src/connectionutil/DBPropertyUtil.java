// Task 9: Database Interaction (Continued)

package connectionutil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBPropertyUtil {

    private DBPropertyUtil() {
    }

    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream input = DBPropertyUtil.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                System.err.println("Sorry, unable to find " + fileName);
                return null;
            }

            // Load a properties file from the class path
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

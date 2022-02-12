package Setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesData {

    static Properties properties;
    static FileInputStream propData;

    private static Properties loadPropertyFile() throws IOException {
        properties = new Properties();
        propData = new FileInputStream("src/main/resources/data.properties");
        properties.load(propData);
        return properties;
    }

    public static String getBrowserNameFromProperty() throws IOException {
        return loadPropertyFile().getProperty("browser");
    }

    public static String getUrlFromProperty() throws IOException {
        return loadPropertyFile().getProperty("Url");
    }
}

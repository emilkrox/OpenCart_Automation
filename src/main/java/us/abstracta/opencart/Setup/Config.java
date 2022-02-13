package us.abstracta.opencart.Setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    static Properties properties;
    static FileInputStream propData;

    private static Properties loadPropertyFile(){
        try {
            properties = new Properties();
            propData = new FileInputStream("src/main/java/us/abstracta/opencart/Config/config.properties");
            properties.load(propData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getBrowserNameFromProperty() {
        return loadPropertyFile().getProperty("browser");
    }

    public static String getUrlFromProperty() {
        return loadPropertyFile().getProperty("Url");
    }


}

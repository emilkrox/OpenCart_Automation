package Setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class SetupDriver {

    static WebDriver driver = null;



    private static String getBrowserNameFromProperty() throws IOException {
        Properties properties = new Properties();
        FileInputStream propData = new FileInputStream("src/main/resources/data.properties");
        properties.load(propData);
        return properties.getProperty("browser");
    }


    private static String getUrlFromProperty() throws IOException {
        Properties properties = new Properties();
        FileInputStream propData = new FileInputStream("src/main/resources/data.properties");
        properties.load(propData);
        return properties.getProperty("Url");
    }



    public static WebDriver loadDriver() throws IOException {
        String browserName = getBrowserNameFromProperty();
        switch (browserName) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                SetupDriver.driver = new ChromeDriver();
            }
            case "internet explorer" -> {
                WebDriverManager.iedriver().setup();
                SetupDriver.driver = new InternetExplorerDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                SetupDriver.driver = new FirefoxDriver();
            }
            case "Edge" -> {
                WebDriverManager.edgedriver().setup();
                SetupDriver.driver = new EdgeDriver();
            }
            default -> System.out.println("This browser " + browserName + "not suported. Please change browser.");
        }
        SetupDriver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        SetupDriver.driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        SetupDriver.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        SetupDriver.driver.get(getUrlFromProperty());

        return SetupDriver.driver;
    }
}

package Setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.time.Duration;

import static Setup.PropertiesData.*;

public class SetupDriver {

    private static WebDriver driver;



    public static WebDriver loadDriver() throws IOException {
        String browserName = getBrowserNameFromProperty();
        String url = getUrlFromProperty();

        switch (browserName) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "internet explorer" -> {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            default -> System.out.println("This browser " + browserName + " not supported. Please change browser.");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get(url);

        return driver;
    }
}

import Setup.SetupDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExampleTest{

    WebDriver driver;

    @BeforeClass
    public void initializeBrovser() throws IOException {
       driver = SetupDriver.loadDriver();
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }


    @Test
    public void test() {
       String url = driver.getCurrentUrl();
       Assert.assertEquals(url, "https://opencart.abstracta.us/");
    }
}

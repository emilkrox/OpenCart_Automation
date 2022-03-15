import us.abstracta.opencart.Pages.AccountPage;
import us.abstracta.opencart.Pages.HomePage;
import us.abstracta.opencart.Pages.LoginPage;
import us.abstracta.opencart.Setup.StartBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;
    StartBrowser startBrowser;
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;

    @BeforeClass
    public void setup() {
       startBrowser = new StartBrowser();
       driver = startBrowser.loadDriver();

       homePage = new HomePage(driver);
       loginPage = new LoginPage(driver);
       accountPage = new AccountPage(driver);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }


    @Test(priority = 1)
    public void currentUrlTest() {
       String url = driver.getCurrentUrl();
       Assert.assertEquals(url, "https://opencart.abstracta.us/");
    }

    @Test(priority = 2)
    public void loginTest() {

        homePage.clickMyAccount();
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickLoginBtn();

        Assert.assertTrue(accountPage.getMyAccountLabel().isDisplayed());
    }

}

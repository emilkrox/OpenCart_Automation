package us.abstracta.opencart.Pages;

import us.abstracta.opencart.TestData.LoadData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    WebDriver driver;
    LoadData loadData = new LoadData();

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#input-email")
    WebElement ReturningCustomerInputEmail;

    @FindBy(css = "#input-password")
    WebElement ReturningCustomerInputPassword;

    @FindBy(css = "[value='Login']")
    WebElement ReturningCustomerLoginBtn;

    public void enterEmail() {
        ReturningCustomerInputEmail.sendKeys(loadData.getEmail());
    }

    public void enterPassword() {
        ReturningCustomerInputPassword.sendKeys(loadData.getPassword());
    }

    public void clickLoginBtn() {
        ReturningCustomerLoginBtn.click();
    }
}
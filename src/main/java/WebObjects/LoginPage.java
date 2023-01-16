package WebObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@type='text']")
    private WebElement loginField;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonLogin;


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public PostsPage login(String login, String password) {
        loginField.sendKeys(login);
        passField.sendKeys(password);
        buttonLogin.click();
        return new PostsPage(driver);
    }
}

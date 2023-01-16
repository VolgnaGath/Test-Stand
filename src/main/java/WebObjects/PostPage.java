package WebObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends BasePage{
    public PostPage(WebDriver driver) {
        super(driver);

    }
    @FindBy(xpath = "//p[@class='item-meta']")
    private WebElement itemMeta;
}

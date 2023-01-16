package WebObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends BasePage{
    public CreatePostPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@type='text']")
    private WebElement title;
    @FindBy(xpath = "//div[@id='SMUI-textfield-helper-text-0']/ancestor::div[@class='field']//textarea")
    private WebElement description;
    @FindBy(xpath = "//div[@id='SMUI-textfield-helper-text-1']/ancestor::div[@class='field']//textarea")
    private WebElement content;
    @FindBy(xpath = "//input[@type='date']")
    private WebElement date;
    @FindBy(xpath = "//span[@class='mdc-button__label']")
    private WebElement buttonSave;
    public PostPage postValue(String titleValue, String descriptionValue, String contentValue, String dataValue) {
        title.sendKeys(titleValue);
        description.sendKeys(descriptionValue);
        content.sendKeys(contentValue);
        date.sendKeys(dataValue);
        buttonSave.click();
        return new PostPage(driver);
    }
}

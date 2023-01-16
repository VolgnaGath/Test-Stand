package WebObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostsPage extends BasePage{
    public PostsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@id='create-btn']")
    private WebElement createButton;
    @FindBy(xpath = "//div[@class='mdc-switch__icons']")
    private WebElement switchIcon;
    @FindBy(xpath = "//a[.='Next Page']")
    private WebElement nextPage;
    @FindBy(xpath = "//a[.='Previous Page']")
    private WebElement previousPage;
    @FindBy(xpath = "//button[@class='mdc-icon-button mdc-icon-button--display-flex mdc-ripple-upgraded--unbounded mdc-ripple-upgraded']//i[@class='material-icons rotate-180 mdc-icon-button__icon']")
    private WebElement sortByNewButton;
    @FindBy(xpath = "//i[@class='material-icons mdc-icon-button__icon mdc-icon-button__icon--on']")
    private WebElement sortByOlderButton;

    public CreatePostPage createPost() {
        createButton.click();
        return new CreatePostPage(driver);
    }
    public void sortByOlder() throws InterruptedException {
        sortByNewButton.click();
        Thread.sleep(5000);
        sortByOlderButton.click();
    }

    public PostsPage goToNextPage() {
        nextPage.click();
        return new PostsPage(driver);
    }
    public void goToPreviousPage() {
        previousPage.click();
    }



}

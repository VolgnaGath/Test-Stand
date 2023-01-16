package WebTests.MainPageTests;

import WebObjects.LoginPage;
import WebObjects.MyUtils;
import WebObjects.PostsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageTests {
    Cookie authCookie = new Cookie("session_id", "%7B%22id%22%3A3673%2C%22username%22%3A%2212344444444%22%2C%22token%22%3A%22cdc7c755d2bc3b5e284f905f56f39415%22%2C%22roles%22%3A%5B%22R_DUMMY%22%2C%22R_USER%22%2C%22P_SUPPORT_MESSAGE_L%22%2C%22P_POST_L%22%2C%22P_POST_C%22%2C%22P_POST_R%22%2C%22P_POST_U%22%2C%22P_POST_D%22%2C%22P_USER_R%22%2C%22P_USER_U%22%2C%22P_USER_LOGOUT%22%2C%22P_USER_LOGIN%22%5D%7D", "/");
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://test-stand.gb.ru/");
        driver.manage().addCookie(authCookie);
        Thread.sleep(5000);
        driver.get("https://test-stand.gb.ru/");
        Thread.sleep(5000);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }
    @Test
    @DisplayName("Создание нового поста")
    @Severity(SeverityLevel.BLOCKER)
    @Attachment(value = "Page screenshot", type = "image/png")
    void createNewPost() {
        try {
            new PostsPage(driver).createPost().postValue("Сосиски тест", "Описание тест", "Контент Тест", "12.12.2009");
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='item-meta']")));
            Assertions.assertTrue(driver.findElement(By.xpath("//p[@class='item-meta']")).isDisplayed());

        }
        catch (Exception exception) {
            MyUtils.makeScreenshot(driver, "failure- WebObjects" + System.currentTimeMillis() + ".png");
            exception.printStackTrace();

        }
    }
    @Test
    @DisplayName("Проверка наличия атрибутов")
    @Severity(SeverityLevel.NORMAL)
    @Attachment(value = "Page screenshot", type = "image/png")
    void checkPostAttributes() {
        try {
            new PostsPage(driver).sortByOlder();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[.='тест торт']")));
            Assertions.assertTrue(driver.findElement(By.xpath("//h2[.='тест торт']")).isDisplayed());
            Assertions.assertTrue(driver.findElement(By.xpath("//div[.='супер торт']")).isDisplayed());
            Assertions.assertTrue(driver.findElement(By.xpath("//img[@src='http://test-stand.gb.ru/files/public/image/9a04fec0eaf2d2b9622a30068f149cc0.jpg']")).isDisplayed());


        }
        catch (Exception exception) {
            MyUtils.makeScreenshot(driver, "failure- WebObjects" + System.currentTimeMillis() + ".png");
            exception.printStackTrace();

        }
    }
    @Test
    @DisplayName("Проверка кнопок следующая/предыдущая страницы")
    @Severity(SeverityLevel.MINOR)
    @Attachment(value = "Page screenshot", type = "image/png")
    void nextPreviousPageTest() {
        try {
            new PostsPage(driver).goToNextPage().goToPreviousPage();
            Assertions.assertTrue(driver.findElement(By.xpath("//a[.='Next Page']")).isDisplayed());


        }
        catch (Exception exception) {
            MyUtils.makeScreenshot(driver, "failure- WebObjects" + System.currentTimeMillis() + ".png");
            exception.printStackTrace();

        }
    }

}

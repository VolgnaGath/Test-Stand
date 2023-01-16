package WebTests.MainPageTests;

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

public class MainPageNoPosts {
    Cookie authCookie = new Cookie("session_id", "%7B%22id%22%3A3695%2C%22username%22%3A%221y%22%2C%22token%22%3A%2213d56519eefb4db983bcf57187924d45%22%2C%22roles%22%3A%5B%22R_DUMMY%22%2C%22R_USER%22%2C%22P_SUPPORT_MESSAGE_L%22%2C%22P_POST_L%22%2C%22P_POST_C%22%2C%22P_POST_R%22%2C%22P_POST_U%22%2C%22P_POST_D%22%2C%22P_USER_R%22%2C%22P_USER_U%22%2C%22P_USER_LOGOUT%22%2C%22P_USER_LOGIN%22%5D%7D", "/");
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
    @DisplayName("Проверка пользователя без постов")
    @Severity(SeverityLevel.MINOR)
    @Attachment(value = "Page screenshot", type = "image/png")
    void nextPreviousPageTest() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[.='No items for your filter']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//p[.='No items for your filter']")).isDisplayed());
    }
}

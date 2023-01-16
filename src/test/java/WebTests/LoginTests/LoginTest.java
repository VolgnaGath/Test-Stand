package WebTests.LoginTests;

import WebObjects.LoginPage;
import WebObjects.MyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://test-stand.gb.ru/login");
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Вход с валидным логином")
    @Severity(SeverityLevel.BLOCKER)
    @Attachment(value = "Page screenshot", type = "image/png")
    void validLoginTest() {
        try {

            new LoginPage(driver).login("12344444444", "fa4d864631");
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='svelte-1rc85o5 mdc-menu-surface--anchor']")));
            Assertions.assertTrue(driver.getCurrentUrl().equals("https://test-stand.gb.ru/"));

        }
        catch (Exception exception) {
            MyUtils.makeScreenshot(driver, "failure- WebObjects" + System.currentTimeMillis() + ".png");
            exception.printStackTrace();

        }
    }

    @Test
    @DisplayName("Вход с невалидным логином")
    @Severity(SeverityLevel.BLOCKER)
    @Attachment(value = "Page screenshot", type = "image/png")
    void invalidLogin() {
        try {

            new LoginPage(driver).login("1y333333", "c0cc76336e");
            Thread.sleep(2000);
            Assertions.assertTrue(driver.getCurrentUrl().equals("https://test-stand.gb.ru/login"));

        }
        catch (Exception exception) {
            MyUtils.makeScreenshot(driver, "failure- WebObjects" + System.currentTimeMillis() + ".png");
            exception.printStackTrace();

        }
    }
    @Test
    @DisplayName("Вход с логином, стостоящим из 2 символов")
    @Severity(SeverityLevel.MINOR)
    @Attachment(value = "Page screenshot", type = "image/png")
    void loginLessThan3Characters() {
        try {

            new LoginPage(driver).login("1y", "c0cc76336e");
            Thread.sleep(2000);
            Assertions.assertTrue(driver.getCurrentUrl().equals("https://test-stand.gb.ru/login"));

        }
        catch (Exception exception) {
            MyUtils.makeScreenshot(driver, "failure- WebObjects" + System.currentTimeMillis() + ".png");
            exception.printStackTrace();

        }
    }
    @Test
    @DisplayName("Вход с логином, стостоящим из 21 символа")
    @Severity(SeverityLevel.MINOR)
    @Attachment(value = "Page screenshot", type = "image/png")
    void loginMoreThan20Characters() {
        try {

            new LoginPage(driver).login("202020202020202020202", "79b7b9eeae");
            Thread.sleep(2000);
            Assertions.assertTrue(driver.getCurrentUrl().equals("https://test-stand.gb.ru/login"));

        }
        catch (Exception exception) {
            MyUtils.makeScreenshot(driver, "failure- WebObjects" + System.currentTimeMillis() + ".png");
            exception.printStackTrace();

        }
    }
}

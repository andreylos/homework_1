package test.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class RozetkaTest {
    WebDriver driver;
    WebDriverWait wait;
    By myCabinet = By.cssSelector("[class='header-topline__user-link link-dashed']");
    By register = By.cssSelector("[class='auth-modal__register-link']");
    By name = By.cssSelector("[formcontrolname='name']");
    By email = By.cssSelector("[formcontrolname='username']");
    By password = By.cssSelector("[formcontrolname='password']");

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        //options.addArguments("--window-size=1300,1080");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void fieldsValidation1() {
        String expectedBorderColor = "rgb(248, 65, 71)";
        driver.get("https://rozetka.com.ua/");
        wait.until(ExpectedConditions.elementToBeClickable(myCabinet));
        driver.findElement(myCabinet).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(register)));
        driver.findElement(register).click(); // кнопка почему то нажимается через раз
        driver.findElement(name).sendKeys(Keys.TAB);
        driver.findElement(email).sendKeys(Keys.TAB);
        driver.findElement(password).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.attributeToBe(name, "border-color", expectedBorderColor));
        String color = driver.findElement(name).getCssValue("border-color");
        assertTrue(expectedBorderColor.equals(color), "Border color should be " + expectedBorderColor + " instead of " + color);
    }

    @Test
    public void fieldsValidation2() {
        String expectedValidatedBorderColor = "rgb(248, 65, 71)";
        String expectedNonValidatedBorderColor = "rgb(210, 210, 210)";
        driver.get("https://rozetka.com.ua/");
        wait.until(ExpectedConditions.elementToBeClickable(myCabinet));
        driver.findElement(myCabinet).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(register)));
        driver.findElement(register).click(); // кнопка почему то нажимается через раз
        driver.findElement(name).sendKeys("Андрей");
        driver.findElement(email).sendKeys(Keys.TAB);
        driver.findElement(password).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.attributeToBe(name, "border-color", expectedNonValidatedBorderColor));
        String colorNameField = driver.findElement(name).getCssValue("border-color");
        assertTrue(expectedNonValidatedBorderColor.equals(colorNameField),
                "Border color should be " + expectedNonValidatedBorderColor + " instead of " + colorNameField);
        wait.until(ExpectedConditions.attributeToBe(email, "border-color", expectedValidatedBorderColor));
        wait.until(ExpectedConditions.attributeToBe(password, "border-color", expectedValidatedBorderColor));
        String colorEmailField = driver.findElement(email).getCssValue("border-color");
        String colorPasswordField = driver.findElement(password).getCssValue("border-color");
        assertTrue(expectedValidatedBorderColor.equals(colorEmailField),
                "Border color should be " + expectedValidatedBorderColor + " instead of " + colorEmailField);
        assertTrue(expectedValidatedBorderColor.equals(colorPasswordField),
                "Border color should be " + expectedValidatedBorderColor + " instead of " + colorPasswordField);
    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}

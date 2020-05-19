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

public class RozetkaTest {
    WebDriver driver;
    WebDriverWait wait;
    //String searchStr = "iPhone";
    //String popupStrSelect = "[class='popup-css lang-switcher-popup sprite-side']";
    By myCabinet = By.cssSelector("[class='header-topline__user-link link-dashed']");
    By register = By.cssSelector("[class='auth-modal__register-link']");
    By enter = By.cssSelector("[class='button button_size_large button_color_green auth-modal__submit']");
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
    public void fieldsValidation1() throws InterruptedException {
        driver.get("https://rozetka.com.ua/");
        wait.until(ExpectedConditions.elementToBeClickable(myCabinet));
        driver.findElement(myCabinet).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(register)));
        driver.findElement(register).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(enter)));
        driver.findElement(name).sendKeys(Keys.TAB);
        driver.findElement(email).sendKeys(Keys.TAB);
        driver.findElement(password).sendKeys(Keys.TAB);
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(name)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(name));
        String color = driver.findElement(name).getCssValue("border-color");
        System.out.println(color);




        Thread.sleep(5000);
//        driver.get("https://rozetka.com.ua/notebooks/c80004/filter/preset=workteaching/");
//        WebElement searchEl2 = driver.findElement(search);
//        wait.until(ExpectedConditions.elementToBeClickable(searchEl2));
//        if( driver.findElements(popup).size() > 0 ) {
//            driver.findElement(popupClose).click();
//        }
//        searchEl2.click();
//        /wait.until(ExpectedConditions.elementToBeClickable(suggestion));
//        wait.until(ExpectedConditions.elementToBeClickable(suggestion)).click();
//        driver.findElement(suggestion).click();
//        wait.until(ExpectedConditions.and(
//                ExpectedConditions.visibilityOfElementLocated(iPhone),
//                ExpectedConditions.urlContains(searchStr.toLowerCase())
//        ));
//        String actual = driver.getCurrentUrl();
//        String expected = "/#search_text=" + searchStr.toLowerCase();
//        assertTrue(actual.contains(expected),
//                String.format("Expected '%s' to contain '%s'", actual, expected));
//
//        driver.findElement(logo).click();
//        new WebDriverWait(driver, 10).until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(iPhone)));
//        new WebDriverWait(driver, 10).until(ExpectedConditions.stalenessOf(driver.findElement(iPhone)));
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}

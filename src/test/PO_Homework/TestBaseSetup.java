package test.PO_Homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.utils.Screenshot;

public class TestBaseSetup {
    public WebDriver driver;
    Screenshot screenshot;

    @BeforeMethod
    public void beforeMethod(ITestContext context){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        screenshot = new Screenshot(driver);
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        driver.quit();
    }
}

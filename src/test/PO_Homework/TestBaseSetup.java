package test.PO_Homework;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import test.utils.Screenshot;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseSetup {
    public WebDriver driver;
    Screenshot screenshot;

    @BeforeMethod
    @Parameters({"browser"})
    public void beforeMethod(ITestContext context, @Optional("chrome") String browser){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Capabilities webDriverBrowser;
        if (browser == "chrome") {
            webDriverBrowser = new ChromeOptions();
        } else {
            webDriverBrowser = new FirefoxOptions();
        }
        //ChromeOptions chrome = new ChromeOptions();
        //chrome.addArguments("--disable-notifications");
        //FirefoxOptions firefox = new FirefoxOptions();
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        screenshot = new Screenshot(driver);
        context.setAttribute("driver", driver);
        try {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), webDriverBrowser);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        driver.quit();
    }
}

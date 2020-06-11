package test.PO_Homework;

import io.qameta.allure.Attachment;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import test.utils.Screenshot;

public class TestBaseSetup {
    public WebDriver driver;
    Screenshot screenshot;

    @BeforeMethod
    @Parameters({"browser"})
    public void beforeMethod(ITestContext context, @Optional("chrome") String browser){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Capabilities webDriverBrowser;
        if (browser.equals("chrome")) {
            webDriverBrowser = new ChromeOptions();
        } else {
            webDriverBrowser = new FirefoxOptions();
        }
        //chrome.addArguments("--disable-notifications");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        screenshot = new Screenshot(driver);
        context.setAttribute("driver", driver);
//        try {
//            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), webDriverBrowser);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        attachString();
        attachScreen();
        driver.quit();
    }
    @Attachment
    private String attachString() {
        return "Hello, some attach";
    }

    @Attachment(value = "screenshot", type = "image/png")
    private byte[] attachScreen() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}

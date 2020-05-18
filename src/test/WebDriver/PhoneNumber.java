package test.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhoneNumber {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        By number = By.xpath("//*[@class='link-dashed']");
        Thread.sleep(2500);
        WebElement numberButton = driver.findElement(number);
        String phone = numberButton.getText();
        System.out.println(phone.replaceAll("[(,),\\s,-]", ""));
        Thread.sleep(2000);
        driver.quit();
    }
}

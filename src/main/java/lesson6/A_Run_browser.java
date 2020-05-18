package main.java.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A_Run_browser {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        Thread.sleep(5000);
        By search = By.cssSelector("[name='search']");
        WebElement searchBar = driver.findElement(search);
        searchBar.sendKeys("Iphone");
        Thread.sleep(5000);
        driver.quit();
    }
}

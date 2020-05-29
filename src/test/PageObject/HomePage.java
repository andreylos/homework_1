package test.PageObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By itemLinks = By.cssSelector("[class='goods-tile__title']");
    private final By productTypeLinks = By.cssSelector("[class='menu-categories__link']");
    private String searchStr;
    private final String manufacturer;
    private final String popupStrSelect = "[class='popup-css lang-switcher-popup sprite-side']";
    Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(css = "[name='search']")
            private WebElement search;
    @FindBy(css = popupStrSelect)
            private WebElement popup;
    @FindBy(css = popupStrSelect + " [class='popup-close']")
            private WebElement popupClose;
    @FindBy(css = "[href='https://rozetka.com.ua/contacts/']")
            private WebElement contactBtn;
    @FindBy(css = "[id="+manufacturer+"]")
            private WebElement manufacturerBtn;




    public HomePage(WebDriver driver) {
        logger.debug("Home Page initialized");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }


    public HomePage open() {
        logger.info("Page open");
        driver.get("https://rozetka.com.ua/");
        logger.debug("URL " + driver.getCurrentUrl());
        logger.error("Test Error");
        logger.warn("Test WARN");
        return this;
    }

    public HomePage search(String searchStr) {
        logger.info("Searching start");
        this.searchStr = searchStr;
        WebElement searchEl = driver.findElement(search);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl));
        if (driver.findElements(popup).size() > 0) {
            driver.findElement(popupClose).click();
        }
        searchEl.sendKeys(this.searchStr);
        searchEl.sendKeys(Keys.ENTER);
        logger.debug("Searching " + searchStr);
        return this;
    }

        public List<WebElement> getItems() {
        logger.info("Getting items");
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemLinks));
        return driver.findElements(itemLinks);
    }

        public List<WebElement> getSideProductTypes() {
        logger.info("Getting product types");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTypeLinks));
        return driver.findElements(productTypeLinks);
        }
    }




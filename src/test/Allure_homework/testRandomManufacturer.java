package test.Allure_homework;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.PO_Homework.TestBaseSetup;
import test.PageObject.HomePage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class testRandomManufacturer extends TestBaseSetup {
    HomePage homePage;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyManufacturersRand() {
        String manufacturer = homePage.openPageAndChooseRandomManufacturer();
        List<WebElement> webLinks = homePage.getProductsLinks();
        Set<Boolean> productLinks = new HashSet<Boolean>();
        for (WebElement element: webLinks) {
            boolean t = element.getText().contains(manufacturer);
            productLinks.add(t);
        }
        Assert.assertFalse(productLinks.contains(false),"One of product links relates to wrong product");
    }
}

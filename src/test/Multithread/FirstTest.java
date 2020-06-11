package test.Multithread;

import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.PO_Homework.TestBaseSetup;
import test.PageObject.HomePage;

public class FirstTest extends TestBaseSetup {
    HomePage homePage;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
    }

    @Feature("Test A")
    @Story("Story AAA")
    @Issue("BRMO-865")
    @Test
    public void testA() {
        homePage.open();
        System.out.println("Page 1 opened");
    }

    @Feature("Test A")
    @Story("Story BBB")
    @Issue("JHGD-231")
    @Test
    public void testB() {
        homePage.open();
        System.out.println("Page 2 opened");
    }
}

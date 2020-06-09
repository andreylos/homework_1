package test.Multithread;

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

    @Test
    public void testA() {
        homePage.open();
        System.out.println("Page 1 opened");
    }

    @Test
    public void testB() {
        homePage.open();
        System.out.println("Page 2 opened");
    }
}

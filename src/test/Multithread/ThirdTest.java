package test.Multithread;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.PO_Homework.TestBaseSetup;
import test.PageObject.HomePage;

public class ThirdTest extends TestBaseSetup {
    HomePage homePage;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
    }

    @Test
    public void testE() {
        homePage.open();
        System.out.println("Page 5 opened");
    }

    @Test
    public void testF() {
        homePage.open();
        System.out.println("Page 6 opened");
    }
}


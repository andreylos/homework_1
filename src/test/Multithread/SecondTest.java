package test.Multithread;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.PO_Homework.TestBaseSetup;
import test.PageObject.HomePage;

public class SecondTest extends TestBaseSetup {
    HomePage homePage;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
    }

    @Test
    public void testC() {
        homePage.open();
        System.out.println("Page 3 opened");
    }

    @Test
    public void testD() {
        homePage.open();
        System.out.println("Page 4 opened");
    }
}


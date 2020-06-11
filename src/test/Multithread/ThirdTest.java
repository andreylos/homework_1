package test.Multithread;

import io.qameta.allure.Step;
import org.testng.Assert;
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
    @Step
    public void testE() {
        homePage.open();
        System.out.println("Page 5 opened");
        Assert.assertTrue(false);
    }

    @Step
    @Test
    public void testF() {
        homePage.open();
        System.out.println("Page 6 opened");
    }
}


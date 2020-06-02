package test.Multithread;

import org.testng.annotations.Test;
import test.PO_Homework.TestBaseSetup;
import test.PageObject.HomePage;

public class FirstTest extends TestBaseSetup {
    HomePage homePage;

    @Test
    public void testA() {
        homePage.open();
        System.out.println("Page opened");
    }
}

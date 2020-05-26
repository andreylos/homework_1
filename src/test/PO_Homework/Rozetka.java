package test.PO_Homework;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.PageObject.HomePage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rozetka extends TestBaseSetup {
    HomePage homePage;

    private String searchQuery = "iPhone";
    private String[] categoryList = {"Ноутбуки и компьютеры", "Смартфоны, ТВ и электроника", "Бытовая техника", "Товары для дома",
            "Инструменты и автотовары", "Сантехника и ремонт", "Дача, сад и огород", "Спорт и увлечения",
            "Одежда, обувь и украшения", "Красота и здоровье", "Детские товары", "Канцтовары и книги", "Алкогольные напитки и продукты",
            "Товары для бизнеса", "Услуги и сервисы", "Продовольственные наборы"};

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyThatLinksContainSearchResult() {
        homePage.open();
        homePage.search(searchQuery);
        List<WebElement> webLinks = homePage.getItems();
        for (WebElement element: webLinks) {
            Assert.assertTrue(element.getText().contains(searchQuery), "Link does not contain " + searchQuery + " in it");
        }
    }

    @Test
    public void verifyThatSidePanelItems() {
        homePage.open();
        List<WebElement> webLinks = homePage.getSideProductTypes();
        ArrayList<String> sideLinks = new ArrayList<String>();
        for (WebElement element: webLinks) {
            String t = element.getText();
            sideLinks.add(t);
        }
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(categoryList));
        Assert.assertTrue(sideLinks.equals(arrayList), "Categories list is wrong on the side panel");
    }
}


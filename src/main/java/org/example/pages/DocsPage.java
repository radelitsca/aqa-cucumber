package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DocsPage extends BasePage {

    public static final String PAGE_TITLE = "//*[@class='page-header']/*[contains(@class, 'title') and contains(text(),'%s')]";
    public static final By MENU_ITEM = By.className("panel-group");

    public boolean isPageWithTitleDisplayed(String title) {
        return isElementDisplayed(By.xpath(String.format(PAGE_TITLE, title)));
    }

    public List<WebElement> getMenuItemTitles() {
        return findElements(MENU_ITEM);
    }
}

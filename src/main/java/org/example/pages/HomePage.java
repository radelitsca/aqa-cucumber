package org.example.pages;

import org.example.driver.DriverManager;
import org.example.utils.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public static final String TEXT_PATTERN = "%s[contains(text(), '%s')]";
    public static final String MENU_SECTION = "//a[contains(@class, 'nav-link')]";
    public static final String CHILD_MENU_ITEM = "//*[contains(@class, 'dropdown')]//*[contains(@class, 'item')]";

    public void openCucumberWebsite() {
        DriverManager.getDriver().get(ConfigProvider.CUCUMBER_WEBSITE);
    }

    public WebElement menuSection(String linkText) {
        return findElement(By.xpath(String.format(TEXT_PATTERN, MENU_SECTION, linkText)));
    }

    public WebElement menuChildItem(String item) {
        return findElement(By.xpath(String.format(TEXT_PATTERN, CHILD_MENU_ITEM, item)));
    }
}

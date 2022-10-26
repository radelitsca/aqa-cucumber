package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.utils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Optional;

public class DriverManager {

    private DriverManager() {
    }

    public static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static void setDriver() {
        WebDriver driver = getChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.IMPLICITLY_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigProvider.PAGE_LOAD_TIMEOUT));
        webDriverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    public static void quitDriver() {
        Optional.ofNullable(getDriver()).ifPresent(webDriver -> {
            webDriver.quit();
            webDriverThreadLocal.remove();
        });
    }

    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

}

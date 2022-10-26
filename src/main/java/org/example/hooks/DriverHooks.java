package org.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class DriverHooks {
    @Before
    public void setupDriver() {
        DriverManager.setDriver();
    }

    @After(order = 0)
    public void quitDriver() {
        DriverManager.quitDriver();
    }

    @After(order = 1)
    public void takeScreenShotOnFailedScenario(Scenario scenario) {

        System.out.println("This is from After hook, order=1");
        if ((scenario.isFailed())) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}

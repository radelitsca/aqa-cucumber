package org.example.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/CucumberTests.html",
                "json:target/cucumber-reports/CucumberTests.json",
                "junit:target/cucumber-reports/CucumberTests.xml"},
        monochrome = false,
        tags = "@smoke",
        glue = "org.example",
        features = "classpath:features"
)
public class CucumberTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}

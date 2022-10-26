package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.DocsPage;
import org.example.pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuSectionsSteps {
    private final HomePage homePage = new HomePage();
    private final DocsPage docsPage = new DocsPage();

    @When("the user opens Cucumber website")
    public void openCucumberWebsite() {
        homePage.openCucumberWebsite();
    }

    @When("the user clicks on the {string} section")
    public void clickOnSection(String section) {
        homePage.menuSection(section).click();
    }

    @When("the user clicks on the {string} item")
    public void clicksOnItem(String item) {
        homePage.menuChildItem(item).click();
    }

    @Then("page with title {string} is displayed")
    public void pageWithTitleIsDisplayed(String pageTitle) {
        assertThat(docsPage.isPageWithTitleDisplayed(pageTitle))
                .withFailMessage("Title is not '{}'", pageTitle)
                .isTrue();
    }
}

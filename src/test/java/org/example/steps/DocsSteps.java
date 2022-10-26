package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.DocsPage;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DocsSteps {

    private static final DocsPage docsPage = new DocsPage();

    @Then("there are {int} items in the left-side menu")
    public void thereAreItemsInTheLeftSideMenu(int expectedSize) {
        assertThat(docsPage.getMenuItemTitles())
                .as("The size is not correct")
                .hasSize(expectedSize);
    }

    @Then("left-side menu contains the following links")
    public void leftSideMenuContainsTheFollowingLinks(List<String> expectedTitles) {
        assertThat(docsPage.getMenuItemTitles())
                .extracting(WebElement::getText)
                .as("Some items of menu are not as expected")
                .containsAll(expectedTitles);
    }
}

package com.company.step_defs;

import com.company.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US1_GoogleSearchStepDefs {
    @When("user is on the Google page")
    public void user_is_on_the_google_page() {
        Driver.getDriver().get("https://www.google.com/");
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}

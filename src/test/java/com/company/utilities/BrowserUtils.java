package com.company.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    /*
    This method will accept int (in seconds)
    and execute Thread.sleep method for given duration
     */

    public static void sleep(int second) {
        second *= 1000;
        try{
            Thread.sleep(second);
        }catch(InterruptedException e){

        }
    }

    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle){
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for(String each : allWindowHandles) {

            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if(Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }

        }

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
        //Method info:
        //• Name: switchWindowAndVerify
        //• Return type: void
        //• Arg1: WebDriver
        //• Arg2: String expectedInUrl
        //• Arg3: String expectedTitle
    }

    /*
    TC #3: Create utility method
    1. Createanewmethodfortitleverification
    2. Createamethodtomaketitleverificationlogicre-usable
    3. Whenmethodiscalled,itshouldsimplyverifyexpectedtitlewithactual
    title
    Method info:
    • Name: verifyTitle()
    • Return type: void
    • Arg1: WebDriver
    • Arg2: String expectedTitle
     */

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    public static void verifyTitleContains(String expectedTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }

    public static void waitForInvisibilityOf(WebElement target) {
        //4- Wait until “loading bar disappears”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(target));

    }

    public static List<String> dropdownOptions_as_STRING(WebElement dropdownElement) {


        Select month = new Select(dropdownElement);
        //Storing all the ACTUAL options into a List of WebElements
        List<WebElement> actualMonth_asWEBELEMENT = month.getOptions();

        //Creating an EMPTY list of String to store ACTUAL <option> as a String
        List<String> actualMonth_as_STRING = new ArrayList<>();

        //Looping through the List<WebElement>, getting all options texts, and storing them into List<String>
        for (WebElement each : actualMonth_asWEBELEMENT) {
            actualMonth_as_STRING.add(each.getText());
        }
        return actualMonth_as_STRING;
    }

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {
        for(WebElement each : radioButtons) {
            if(each.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                each.click();
            }
        }
    }

    public static void verifyURLContains(String expectedInURL) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

}

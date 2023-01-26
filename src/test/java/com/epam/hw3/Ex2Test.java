package com.epam.hw3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;
import static testdata.TestData.itemLogs;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Ex2Test extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void ex2Tests() {
        //step 2 - Assert Browser title
        assertThat(driver.getTitle()).isEqualTo("Home Page");

        //step 3 - Perform login
        //step 4 - Assert Username is loggined
        mainPage.login("Roman", "Jdi1234");
        String userName = mainPage.getUserName().getText();
        assertThat(userName).isEqualTo("ROMAN IOVLEV");

        //step 5 - Open through the header menu Service -> Different Elements Page
        headerPage.clickService();
        headerPage.clickDiffEl();

        //step 6 - Select checkboxes Water, Wind
        diffElementPage.checkbox("Water").click();
        softAssert.assertTrue(diffElementPage.checkbox("Water").isSelected());

        diffElementPage.checkbox("Wind").click();
        softAssert.assertTrue(diffElementPage.checkbox("Wind").isSelected());

        //step 7 - Select radio Selen
        diffElementPage.radiobutton("Selen").click();
        softAssert.assertTrue(diffElementPage.radiobutton("Selen").isSelected());

        //step 8 - Select in dropdown Yellow
        diffElementPage.dropdown("Yellow").click();
        softAssert.assertTrue(diffElementPage.dropdown("Yellow").isSelected());

        //step 9 -Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //• for radio button there is a log row and value is corresponded to the status of radio button
        //• for dropdown there is a log row and value is corresponded to the selected value.
        List<String> left = diffElementPage.getLog().stream().map(WebElement::getText).collect(Collectors.toList());
        softAssert.assertTrue(left.contains(String.valueOf(itemLogs)));
        diffElementPage.getLog().forEach(e -> assertTrue(e.isDisplayed()));
    }
}

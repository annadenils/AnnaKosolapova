package com.epam.hw3;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;
import static testdata.TestData.itemLogs;

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
        diffElementPage.getCheckbox("Water").click();
        softAssert.assertTrue(diffElementPage.getCheckbox("Water").isSelected());

        diffElementPage.getCheckbox("Wind").click();
        softAssert.assertTrue(diffElementPage.getCheckbox("Wind").isSelected());

        //step 7 - Select radio Selen
        diffElementPage.getRadiobutton("Selen").click();
        softAssert.assertTrue(diffElementPage.getRadiobutton("Selen").isSelected());

        //step 8 - Select in dropdown Yellow
        diffElementPage.getDropdown("Yellow").click();
        softAssert.assertTrue(diffElementPage.getDropdown("Yellow").isSelected());

        //step 9 -Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //• for radio button there is a log row and value is corresponded to the status of radio button
        //• for dropdown there is a log row and value is corresponded to the selected value.
        List<String> left = diffElementPage.log.stream().map(WebElement::getText).collect(Collectors.toList());
        softAssert.assertTrue(left.contains(String.valueOf(itemLogs)));
        diffElementPage.log.forEach(e -> assertTrue(e.isDisplayed()));
    }
}

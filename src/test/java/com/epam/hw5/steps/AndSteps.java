package com.epam.hw5.steps;

import io.cucumber.java.en.And;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class AndSteps extends BaseStep {
    SoftAssert softAssert = new SoftAssert();

    protected AndSteps(WebDriver driver) throws IOException {
        super(driver);
    }

    public AndSteps() throws IOException {
        super(driver);
    }

    @And("checkbox {string} is selected")
    public void checkboxSelected(String checkbox) {
        softAssert.assertTrue(diffElementPage.checkbox(checkbox).isSelected());
    }

    @And("radiobutton {string} is selected")
    public void radiobuttonSelected(String radiobutton) {
        softAssert.assertTrue(diffElementPage.radiobutton(radiobutton).isSelected());
    }


    @And("dropdown {string} is selected")
    public void dropdownIsSelected(String arg0) {
        softAssert.assertTrue(diffElementPage.dropdown(arg0).isSelected());
    }
}

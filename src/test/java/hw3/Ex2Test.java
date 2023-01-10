package hw3;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.assertj.core.api.Assertions.assertThat;

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
        diffElementPage.getCheckbox()
                .stream()
                .filter(element1 -> element1.getText().equals("Water"))
                .findFirst().orElseThrow(() -> new RuntimeException("Checkbox with name " + "Water" + " not found"))
                .click();

        softAssert.assertTrue(diffElementPage.getCheckbox()
                .stream()
                .filter(e -> e.getText().equals("Water"))
                .findFirst().orElseThrow(() -> new RuntimeException("Checkbox with name " + "Water" + " not found"))
                .isSelected());

        diffElementPage.getCheckbox()
                .stream()
                .filter(element1 -> element1.getText().equals("Wind"))
                .findFirst().orElseThrow(() -> new RuntimeException("Checkbox with name " + "Wind" + " not found"))
                .click();

        softAssert.assertTrue(diffElementPage.getCheckbox()
                .stream()
                .filter(e -> e.getText().equals("Wind"))
                .findFirst().orElseThrow(() -> new RuntimeException("Checkbox with name " + "Wind" + " not found"))
                .isSelected());


        //step 7 - Select radio Selen
        diffElementPage.getRadiobutton()
                .stream()
                .filter(element1 -> element1.getText().equals("Selen"))
                .findFirst().orElseThrow(() -> new RuntimeException("Radiobutton with name " + "Selen" + " not found"))
                .click();

        softAssert.assertTrue(diffElementPage.getRadiobutton()
                .stream()
                .filter(element1 -> element1.getText().equals("Selen"))
                .findFirst().orElseThrow(() -> new RuntimeException("Radiobutton with name " + "Selen" + " not found"))
                .isSelected());

        //step 8 - Select in dropdown Yellow
        diffElementPage.getDropdown()
                .stream()
                .filter(element1 -> element1.getText().equals("Yellow"))
                .findFirst().orElseThrow(() -> new RuntimeException("Dropdown with name " + "Yellow" + " not found"))
                .click();

        softAssert.assertTrue(BaseTest.diffElementPage.getDropdown()
                .stream()
                .filter(element1 -> element1.getText().equals("Yellow"))
                .findFirst().orElseThrow(() -> new RuntimeException("Dropdown with name " + "Yellow" + " not found"))
                .isSelected());

        //step 9 -Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //• for radio button there is a log row and value is corresponded to the status of radio button
        //• for dropdown there is a log row and value is corresponded to the selected value.
        softAssert.assertTrue(BaseTest.diffElementPage.getLog()
                .stream()
                .filter(element1 -> element1.getText().contains("Water: condition changed to true"))
                .findFirst().orElseThrow(() -> new RuntimeException("Log: " + "Water: condition changed to true" + " not found"))
                .isDisplayed());

        softAssert.assertTrue(BaseTest.diffElementPage.getLog()
                .stream()
                .filter(element1 -> element1.getText().contains("Wind: condition changed to true"))
                .findFirst().orElseThrow(() -> new RuntimeException("Log: " + "Wind: condition changed to true"
                        + " not found"))
                .isDisplayed());

        softAssert.assertTrue(BaseTest.diffElementPage.getLog()
                .stream()
                .filter(element1 -> element1.getText().contains("metal: value changed to Selen"))
                .findFirst().orElseThrow(() -> new RuntimeException("Log: " + "metal: value changed to Selen"
                        + " not found"))
                .isDisplayed());

        softAssert.assertTrue(BaseTest.diffElementPage.getLog()
                .stream()
                .filter(element1 -> element1.getText().contains("Colors: value changed to Yellow"))
                .findFirst().orElseThrow(() -> new RuntimeException("Log: " + "Colors: value changed to Yellow"
                        + " not found"))
                .isDisplayed());
    }
}

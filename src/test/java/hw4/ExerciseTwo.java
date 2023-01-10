package hw4;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class ExerciseTwo extends BaseTest {

    @Story("Main Page Information Framework")
    @Feature("Dropdowns")
    @Test
    public void ExerciseTwo(){
        assertStep.browserTitle();
        actionStep.login();
        assertStep.assertLogin();
        actionStep.clickDropdownServise();
        actionStep.clickDifferentElements();
        actionStep.selectCheckbox("Water");
        assertStep.checkboxIsSelected("Water");
        actionStep.selectCheckbox("Wind");
        assertStep.checkboxIsSelected("Wind");
        actionStep.radiobuttonSelect("Selen");
        assertStep.radiobuttonIsSelected("Selen");
        actionStep.dropdownSelect("Yellow");
        assertStep.dropdownIsSelected("Yellow");
        assertStep.checkLogText("Water: condition changed to true");
        assertStep.checkLogText("Wind: condition changed to true");
        assertStep.checkLogText("metal: value changed to Selen");
        assertStep.checkLogText("Colors: value changed to Yellow");
    }

}

package hw4;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static hw4.DiffElementPage.*;

public class ExerciseTwo extends AbstractForHW4{

    @Story("Main Page Information Framework")
    @Feature("Dropdowns")
    @Test
    public void ExerciseTwo(){
        assertStep.browserTitle();
        actionStep.login();
        assertStep.assertLogin();
        actionStep.clickDropdownServise();
        actionStep.clickDifferentElements();
        actionStep.checkboxSelect(water);
        assertStep.elementIsSelected(water);
        actionStep.checkboxSelect(wind);
        assertStep.elementIsSelected(wind);
        actionStep.radiobuttonSelect(selen);
        assertStep.elementIsSelected(selen);
        actionStep.dropdownSelect(yellow);
        assertStep.elementIsSelected(yellow);
        assertStep.checkLog();
    }

}

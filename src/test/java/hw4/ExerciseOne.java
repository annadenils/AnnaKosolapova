package hw4;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


public class ExerciseOne extends InitialisationForHW4 {

    @Story("Main Page Information Framework")
    @Feature("Main page")
    @Test
    public void ExerciseOne(){
        assertStep.browserTitle();
        actionStep.login();
        assertStep.assertLogin();
        assertStep.headerItems();
        assertStep.imagesIndexPage();
        assertStep.textUnderImagesPage();
        assertStep.frame();
        actionStep.switchToFrame();
        assertStep.frameButton();
        actionStep.switchToDefault();
        assertStep.itemsLeftSection();
    }
}

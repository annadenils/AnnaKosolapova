package hw4;

import org.testng.annotations.Test;


public class ExerciseFail extends BaseTest {

    @Test
    public void ExerciseOne(){
        assertStep.browserTitle();
        actionStep.login();
        assertStep.assertLogin();
        assertStep.headerItems();
        assertStep.imagesIndexPage();
        assertStep.textUnderImagesPageFail();
        assertStep.frame();
        actionStep.switchToFrame();
        assertStep.frameButton();
        actionStep.switchToDefault();
        assertStep.itemsLeftSection();
    }
}

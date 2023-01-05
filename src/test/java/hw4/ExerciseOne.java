package hw4;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class ExerciseOne extends AbstractForHW4{

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

package com.epam.hw4;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


public class ExerciseOneTest extends BaseTest {

    @Story("Main Page Information Framework")
    @Feature("Main page")
    @Test
    public void exerciseOne() {
        assertStep.browserTitle("Home Page");
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

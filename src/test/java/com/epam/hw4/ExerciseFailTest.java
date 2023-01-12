package com.epam.hw4;

import org.testng.annotations.Test;


public class ExerciseFailTest extends BaseTest {

    @Test
    public void failTest() {
        assertStep.browserTitle("Home Page");
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

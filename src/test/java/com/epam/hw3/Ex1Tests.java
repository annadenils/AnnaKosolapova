package com.epam.hw3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static testdata.TestData.iconsText;
import static testdata.TestData.itemHeader;
import static testdata.TestData.itemLeftMenu;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.MainPage;


public class Ex1Tests extends BaseTest {

    @Test
    public void ex1Tests() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        //step 2 - Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //step 3 - Perform login
        //step 4 - Assert Username is loggined
        mainPage.login("Roman", "Jdi1234");
        String userName = mainPage.getUserName().getText();
        assertThat(userName).isEqualTo("ROMAN IOVLEV");

        //step 5 - Assert that there are 4 items on the header section are displayed, and they have proper texts
        int headerCount = mainPage.headerItems.size();
        assertThat(headerCount).isEqualTo(4);
        List<String> headerItems = mainPage.headerItems
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(headerItems).containsExactlyElementsOf(itemHeader);
        mainPage.headerItems.forEach(e -> assertTrue(e.isDisplayed()));

        //step 6 - Assert that there are 4 images on the Index Page, and they are displayed
        int iconsCount = mainPage.iconsItems.size();
        assertEquals(iconsCount, 4);
        mainPage.iconsItems.forEach(e -> assertTrue(e.isDisplayed()));

        //step 7 - Assert that there are 4 texts on the Index Page under icons, and they have proper text
        int iconsTextCount = mainPage.iconsTextItems.size();
        assertThat(iconsTextCount).isEqualTo(4);
        List<String> textUnderIcons = mainPage.iconsTextItems
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(textUnderIcons).containsExactlyElementsOf(iconsText);

        //step 8 - Assert that there is the iframe with “Frame Button” exist
        //step 9 - Switch to the iframe and check that there is “Frame Button” in the iframe
        //step 10 - Switch to original window back
        assertTrue(mainPage.frame.isDisplayed());
        driver.switchTo().frame("frame");
        assertTrue(mainPage.frameButton.isDisplayed());
        driver.switchTo().defaultContent();

        //step 11 - Assert that there are 5 items in the Left Section are displayed, and they have proper text
        int leftMenuCount = mainPage.leftMenu.size();
        assertThat(leftMenuCount).isEqualTo(5);
        List<String> leftMenuItems = mainPage.leftMenu
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(leftMenuItems).containsExactlyElementsOf(itemLeftMenu);
    }
}

package com.epam.hw4.steps;


import static com.epam.hw4.BaseTest.diffElementPage;
import static com.epam.hw4.BaseTest.mainPage;
import static com.epam.testdata.TestData.iconsText;
import static com.epam.testdata.TestData.iconsTextFail;
import static com.epam.testdata.TestData.itemHeader;
import static com.epam.testdata.TestData.itemLeftMenu;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;



public class AssertSteps {

    private final WebDriver driver;

    public AssertSteps(WebDriver driver) {
        this.driver = driver;
    }

    SoftAssert softAssert = new SoftAssert();

    @Step("Assert Browser title")
    public void browserTitle() {
        softAssert.assertEquals(driver.getTitle(), "Home Page");
        softAssert.assertAll();
    }

    @Step("assertion login")
    public void assertLogin() {
        String userName = mainPage.getUserName().getText();
        softAssert.assertEquals(userName, "ROMAN IOVLEV");
        softAssert.assertAll();
    }

    @Step("Items in header")
    public void headerItems() {
        int headerCount = mainPage.getHeaderItems().size();
        assertThat(headerCount).isEqualTo(4);
        List<String> headerItems = mainPage.getHeaderItems()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(headerItems).containsExactlyElementsOf(itemHeader);
        mainPage.getHeaderItems().forEach(e -> assertTrue(e.isDisplayed()));
    }

    @Step("Images on the Index Page")
    public void imagesIndexPage() {
        int iconsCount = mainPage.getIconsItems().size();
        softAssert.assertEquals(iconsCount, 4);
        mainPage.getIconsItems().forEach(e -> assertTrue(e.isDisplayed()));
        softAssert.assertAll();
    }

    @Step("Text under images on the Index Page")
    public void textUnderImagesPage() {
        int iconsTextCount = mainPage.getIconsTextItems().size();
        assertThat(iconsTextCount).isEqualTo(4);
        List<String> textUnderIcons = mainPage.getIconsTextItems()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(textUnderIcons).containsExactlyElementsOf(iconsText);
    }

    @Step("Text under images on the Index Page (fail)")
    public void textUnderImagesPageFail() {
        int iconsTextCount = mainPage.getIconsTextItems().size();
        assertThat(iconsTextCount).isEqualTo(4);
        List<String> textUnderIcons = mainPage.getIconsTextItems()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(textUnderIcons).containsExactlyElementsOf(iconsTextFail);
    }

    @Step("frame is displayed")
    public void frame() {
        softAssert.assertTrue(mainPage.getFrame().isDisplayed());
        softAssert.assertAll();
    }

    @Step("Frame button is displayed")
    public void frameButton() {
        softAssert.assertTrue(mainPage.getFrameButton().isDisplayed());
        softAssert.assertAll();
    }

    @Step("Items in the Left Section")
    public void itemsLeftSection() {
        int leftMenuCount = mainPage.getLeftMenu().size();
        assertThat(leftMenuCount).isEqualTo(5);
        List<String> leftMenuItems = mainPage.getLeftMenu()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(leftMenuItems).containsExactlyElementsOf(itemLeftMenu);
    }

    @Step("Checkbox is selected")
    public void checkboxIsSelected(String element) {
        softAssert.assertTrue(diffElementPage.checkbox(element).isSelected());
    }

    @Step("Radiobutton is selected")
    public void radiobuttonIsSelected(String element) {
        softAssert.assertTrue(diffElementPage.radiobutton(element).isSelected());
    }

    @Step("Dropdown is selected")
    public void dropdownIsSelected(String element) {
        softAssert.assertTrue(diffElementPage.dropdown(element).isSelected());
    }

    @Step("Check log text")
    public void checkLogText(String element) {
        softAssert.assertTrue(diffElementPage.log(element).isDisplayed());
    }
}

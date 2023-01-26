package com.epam.hw6.steps;

import static com.epam.testdata.TestData.iconsText;
import static com.epam.testdata.TestData.iconsTextFail;
import static com.epam.testdata.TestData.itemHeader;
import static com.epam.testdata.TestData.itemLeftMenu;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

import com.epam.hw6.BaseTest;
import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class AssertSteps {

    protected WebDriver driver;

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
        String userName = BaseTest.mainPage.getUserName().getText();
        softAssert.assertEquals(userName, "ROMAN IOVLEV");
        softAssert.assertAll();
    }

    @Step("Items in header")
    public void headerItems() {
        int headerCount = BaseTest.mainPage.getHeaderItems().size();
        assertThat(headerCount).isEqualTo(4);
        List<String> headerItems = BaseTest.mainPage.getHeaderItems()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(headerItems).containsExactlyElementsOf(itemHeader);
        BaseTest.mainPage.getHeaderItems().forEach(e -> assertTrue(e.isDisplayed()));
    }

    @Step("Images on the Index Page")
    public void imagesIndexPage() {
        int iconsCount = BaseTest.mainPage.getIconsItems().size();
        softAssert.assertEquals(iconsCount, 4);
        BaseTest.mainPage.getIconsItems().forEach(e -> assertTrue(e.isDisplayed()));
        softAssert.assertAll();
    }

    @Step("Text under images on the Index Page")
    public void textUnderImagesPage() {
        int iconsTextCount = BaseTest.mainPage.getIconsTextItems().size();
        assertThat(iconsTextCount).isEqualTo(4);
        List<String> textUnderIcons = BaseTest.mainPage.getIconsTextItems()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(textUnderIcons).containsExactlyElementsOf(iconsText);
    }

    @Step("Text under images on the Index Page (fail)")
    public void textUnderImagesPageFail() {
        int iconsTextCount = BaseTest.mainPage.getIconsTextItems().size();
        assertThat(iconsTextCount).isEqualTo(4);
        List<String> textUnderIcons = BaseTest.mainPage.getIconsTextItems()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(textUnderIcons).containsExactlyElementsOf(iconsTextFail);
    }

    @Step("frame is displayed")
    public void frame() {
        softAssert.assertTrue(BaseTest.mainPage.getFrame().isDisplayed());
        softAssert.assertAll();
    }

    @Step("Frame button is displayed")
    public void frameButton() {
        softAssert.assertTrue(BaseTest.mainPage.getFrameButton().isDisplayed());
        softAssert.assertAll();
    }

    @Step("Items in the Left Section")
    public void itemsLeftSection() {
        int leftMenuCount = BaseTest.mainPage.getLeftMenu().size();
        assertThat(leftMenuCount).isEqualTo(5);
        List<String> leftMenuItems = BaseTest.mainPage.getLeftMenu()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(leftMenuItems).containsExactlyElementsOf(itemLeftMenu);
    }

    @Step("Checkbox is selected")
    public void checkboxIsSelected(String element) {
        softAssert.assertTrue(BaseTest.diffElementPage.getCheckbox()
                .stream()
                .filter(e -> e.getText().equals(element))
                .findFirst().orElseThrow(() -> new RuntimeException("Checkbox with name " + element + " not found"))
                .isSelected());
    }

    @Step("Radiobutton is selected")
    public void radiobuttonIsSelected(String element) {
        softAssert.assertTrue(BaseTest.diffElementPage.getRadiobutton()
                .stream()
                .filter(element1 -> element1.getText().equals(element))
                .findFirst().orElseThrow(() -> new RuntimeException("Radiobutton with name " + element + " not found"))
                .isSelected());
    }

    @Step("Dropdown is selected")
    public void dropdownIsSelected(String element) {
        softAssert.assertTrue(BaseTest.diffElementPage.getDropdown()
                .stream()
                .filter(element1 -> element1.getText().equals(element))
                .findFirst().orElseThrow(() -> new RuntimeException("Dropdown with name " + element + " not found"))
                .isSelected());
    }

    @Step("Check log text")
    public void checkLogText(String element) {
        softAssert.assertTrue(BaseTest.diffElementPage.getLog()
                .stream()
                .filter(element1 -> element1.getText().contains(element))
                .findFirst().orElseThrow(() -> new RuntimeException("Log: " + element + " not found"))
                .isDisplayed());
    }
}

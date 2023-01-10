package hw4.steps;

import hw4.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;
import static testdata.TestData.*;


public class AssertSteps{

    protected WebDriver driver;

    public AssertSteps(WebDriver driver) {
        this.driver = driver;
    }

    SoftAssert softAssert = new SoftAssert();

    @Step("Assert Browser title")
    public void browserTitle(){
        softAssert.assertEquals(driver.getTitle(), "Home Page");
        softAssert.assertAll();
    }

    @Step("assertion login")
    public void assertLogin(){
        String userName = BaseTest.mainPage.getUserName().getText();
        softAssert.assertEquals(userName, "ROMAN IOVLEV");
        softAssert.assertAll();
    }

    @Step("Items in header")
    public void headerItems(){
        int headerCount = BaseTest.mainPage.headerName().size();
        assertThat(headerCount).isEqualTo(4);
        List<String> headerItems = BaseTest.mainPage.headerName().
                stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(headerItems).containsExactlyElementsOf(itemHeader);
        BaseTest.mainPage.headerName().forEach(e -> assertTrue(e.isDisplayed()));

    }

    @Step("Images on the Index Page")
    public void imagesIndexPage(){
        int iconsCount = BaseTest.mainPage.iconsItems().size();
        softAssert.assertEquals(iconsCount, 4);
        BaseTest.mainPage.iconsItems().forEach(e->assertTrue(e.isDisplayed()));
        softAssert.assertAll();
    }

    @Step("Text under images on the Index Page")
    public void textUnderImagesPage(){
        int iconsTextCount = BaseTest.mainPage.iconsTextItems().size();
        assertThat(iconsTextCount).isEqualTo(4);
        List<String> textUnderIcons = BaseTest.mainPage.iconsTextItems()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(textUnderIcons).containsExactlyElementsOf(iconsText);
    }
    @Step("Text under images on the Index Page (fail)")
    public void textUnderImagesPageFail(){
        int iconsTextCount = BaseTest.mainPage.iconsTextItems().size();
        assertThat(iconsTextCount).isEqualTo(4);
        List<String> textUnderIcons = BaseTest.mainPage.iconsTextItems()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(textUnderIcons).containsExactlyElementsOf(iconsTextFail);
    }

    @Step("frame is displayed")
    public void frame(){
        softAssert.assertTrue(BaseTest.mainPage.frame.isDisplayed());
        softAssert.assertAll();
    }

    @Step("Frame button is displayed")
    public void frameButton(){
        softAssert.assertTrue(BaseTest.mainPage.frameButton.isDisplayed());
        softAssert.assertAll();
    }

    @Step("Items in the Left Section")
    public void itemsLeftSection(){
        int leftMenuCount = BaseTest.mainPage.leftMenuName().size();
        assertThat(leftMenuCount).isEqualTo(5);
        List<String> leftMenuItems = BaseTest.mainPage.leftMenuName()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(leftMenuItems).containsExactlyElementsOf(itemLeftMenu);
    }

    @Step("Checkbox is selected")
    public void checkboxIsSelected(String element) {
        softAssert.assertTrue(BaseTest.diffElementPage.getCheckbox()
                .stream()
                .filter(e -> e.getText().equals(element))
                .findFirst().orElseThrow(()->new RuntimeException("Checkbox with name " + element + " not found"))
                .isSelected());
    }

    @Step("Radiobutton is selected")
    public void radiobuttonIsSelected(String element){
        softAssert.assertTrue(BaseTest.diffElementPage.getRadiobutton()
                .stream()
                .filter(element1 -> element1.getText().equals(element))
                .findFirst().orElseThrow(()-> new RuntimeException("Radiobutton with name " + element+ " not found"))
                .isSelected());
    }

    @Step("Dropdown is selected")
    public void dropdownIsSelected(String element){
        softAssert.assertTrue(BaseTest.diffElementPage.getDropdown()
                .stream()
                .filter(element1 -> element1.getText().equals(element))
                .findFirst().orElseThrow(()-> new RuntimeException("Dropdown with name " + element+ " not found"))
                .isSelected());
    }
    @Step("Check log text")
    public void checkLogText(String element){
        softAssert.assertTrue(BaseTest.diffElementPage.getLog()
                .stream()
                .filter(element1 -> element1.getText().contains(element))
                .findFirst().orElseThrow(()-> new RuntimeException("Log: " + element + " not found"))
                .isDisplayed());
    }
}

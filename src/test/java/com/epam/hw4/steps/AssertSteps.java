package com.epam.hw4.steps;


import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;
import static testdata.TestData.iconsText;
import static testdata.TestData.iconsTextFail;
import static testdata.TestData.itemHeader;
import static testdata.TestData.itemLeftMenu;

import com.epam.hw4.BaseTest;
import com.epam.hw5.steps.BaseStep;
import io.cucumber.datatable.DataTable;
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
    public void browserTitle(String browserTitle) {
        assertThat(driver.getTitle()).isEqualTo(browserTitle);
    }

    @Step("assertion login")
    public void assertLogin() {
        String userName = BaseTest.mainPage.getUserName().getText();
        softAssert.assertEquals(userName, "ROMAN IOVLEV");
        softAssert.assertAll();
    }

    @Step("Items in header")
    public static void headerItems() {
        int headerCount = BaseTest.mainPage.headerName().size();
        assertThat(headerCount).isEqualTo(4);
        List<String> headerItems = BaseTest.mainPage.headerName()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(headerItems).containsExactlyElementsOf(itemHeader);
        BaseTest.mainPage.headerName().forEach(e -> assertTrue(e.isDisplayed()));
    }

    @Step("Images on the Index Page")
    public void imagesIndexPage() {
        int iconsCount = BaseTest.mainPage.iconsItems().size();
        softAssert.assertEquals(iconsCount, 4);
        BaseTest.mainPage.iconsItems().forEach(e -> assertTrue(e.isDisplayed()));
        softAssert.assertAll();
    }

    @Step("Text under images on the Index Page")
    public void textUnderImagesPage() {
        int iconsTextCount = BaseTest.mainPage.iconsTextItems().size();
        assertThat(iconsTextCount).isEqualTo(4);
        List<String> textUnderIcons = BaseTest.mainPage.iconsTextItems()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(textUnderIcons).containsExactlyElementsOf(iconsText);
    }

    @Step("Text under images on the Index Page (fail)")
    public void textUnderImagesPageFail() {
        int iconsTextCount = BaseTest.mainPage.iconsTextItems().size();
        assertThat(iconsTextCount).isEqualTo(4);
        List<String> textUnderIcons = BaseTest.mainPage.iconsTextItems()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(textUnderIcons).containsExactlyElementsOf(iconsTextFail);
    }

    @Step("frame is displayed")
    public void frame() {
        softAssert.assertTrue(BaseTest.mainPage.frame.isDisplayed());
        softAssert.assertAll();
    }

    @Step("Frame button is displayed")
    public void frameButton() {
        softAssert.assertTrue(BaseTest.mainPage.frameButton.isDisplayed());
        softAssert.assertAll();
    }

    @Step("Items in the Left Section")
    public void itemsLeftSection() {
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

    @Step("Dropdown Type are displayed on User Table Page")
    public void checkListOfDropdownTypeOnUserTable(int count) {
        int listOfDropdownTypeCount = BaseStep.userTablePage.getListOfDropdownTypeOnUserTable().size();
        assertThat(listOfDropdownTypeCount).isEqualTo(count);
        assertTrue(BaseStep.userTablePage.getListOfDropdownTypeOnUserTable()
                .stream().findFirst().orElseThrow(() -> new RuntimeException("dropdown not found")).isDisplayed());
    }

    @Step("Users are displayed on User Table Page")
    public void checkListOfUsersOnUserTable(int count) {
        int listOfUsersCount = BaseStep.userTablePage.listOfUsersOnUserTable.size();
        assertThat(listOfUsersCount).isEqualTo(count);
        assertTrue(BaseStep.userTablePage.listOfUsersOnUserTable.stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Field of users not found")).isDisplayed());
    }

    @Step("Descriptions under images are displayed on User Table Page")
    public void checkListOfDescriptionsOnUserTable(int count) {
        int listOfDescriptionCount = BaseStep.userTablePage.listOfDescriptionOnUserTable.size();
        assertThat(listOfDescriptionCount).isEqualTo(count);
        assertTrue(BaseStep.userTablePage.listOfDescriptionOnUserTable.stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Field of description not found")).isDisplayed());
    }

    @Step("Checkboxes are displayed on User Table Page")
    public void checkListOfCheckboxesOnUserTable(int count) {
        int listOfCheckboxesCount = BaseStep.userTablePage.listOfCheckboxOnUserTable.size();
        assertThat(listOfCheckboxesCount).isEqualTo(count);
        assertTrue(BaseStep.userTablePage.listOfCheckboxOnUserTable.stream()
                .findFirst().orElseThrow(() -> new RuntimeException("Field of checkbox not found")).isDisplayed());
    }

    public void userTableShouldContainFollowingValues(DataTable dataTable) {
        List<String> numbers = dataTable.column(1);
        List<String> users = dataTable.column(2);
        List<String> description = dataTable.column(3);
        List<String> usersFromUserPage = BaseStep.userTablePage.listOfUsersOnUserTable
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(users).containsExactlyElementsOf(usersFromUserPage);
    }

    @Step("Check contain data from task and dropdown for Roman")
    public void checkDataAndDropdownForRoman(DataTable dataForRoman) {
        List<String> dataFromTask = dataForRoman.column(1);
        List<String> dropdownForRoman = BaseStep.userTablePage.listOfDropDownForRoman
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(dataFromTask).containsExactlyElementsOf(dropdownForRoman);
    }
}

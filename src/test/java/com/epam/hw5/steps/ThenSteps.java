package com.epam.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.DiffElementPage;
import pages.UserTablePage;

public class ThenSteps extends BaseStep {

    SoftAssert softAssert = new SoftAssert();

    protected ThenSteps(WebDriver driver) throws IOException {
        super(driver);
    }

    public ThenSteps() throws IOException {
        super(driver);
    }

    @Then("Page title is {string}")
    public void page_title_is_home_page(String browserTitle) {
        assertThat(driver.getTitle()).isEqualTo(browserTitle);
    }

    @Then("Check login and user name")
    public void checkLogin() {
        String userName = mainPage.getUserName().getText();
        assertEquals(userName, "ROMAN IOVLEV");
    }

    @Then("Select checkbox {string}")
    public void selectCheckbox(String checkbox) {
        diffElementPage = new DiffElementPage(driver);
        diffElementPage.checkbox(checkbox).click();
    }

    @Then("Select radiobutton {string}")
    public void selectRadiobutton(String radiobutton) {
        diffElementPage.radiobutton
                .stream()
                .filter(element1 -> element1.getText().equals(radiobutton)).findFirst()
                .orElseThrow(() -> new RuntimeException(
                        String.format("Radiobutton with name %s not found", radiobutton)))
                .click();
    }

    @Then("Select dropdown {string}")
    public void selectDropdown(String dropdown) {
        diffElementPage.dropdown
                .stream()
                .filter(element1 -> element1.getText().equals(dropdown)).findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Dropdown with name %s not found", dropdown)))
                .click();
    }

    @Then("Logs {string} is displayed")
    public void logsAreDisplayed(String logs) {
        diffElementPage = new DiffElementPage(driver);
        diffElementPage.log.forEach(element -> assertTrue(element.isDisplayed()));
    }

    @Then("I click on User Table button in Service dropdown")
    public void clickOnUserTableInDropdown() {
        headerPage.clickUserTable();
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        userTablePage = new UserTablePage(driver);
        int listOfDropdownTypeCount = userTablePage.getListOfDropdownTypeOnUserTable().size();
        assertThat(listOfDropdownTypeCount).isEqualTo(count);
        assertTrue(userTablePage.getListOfDropdownTypeOnUserTable()
                .stream().findFirst().orElseThrow(() -> new RuntimeException("dropdown not found")).isDisplayed());
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        int listOfUsersCount = userTablePage.listOfUsersOnUserTable.size();
        assertThat(listOfUsersCount).isEqualTo(count);
        assertTrue(userTablePage.listOfUsersOnUserTable.stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Field of users not found")).isDisplayed());
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        int listOfDescriptionCount = userTablePage.listOfDescriptionOnUserTable.size();
        assertThat(listOfDescriptionCount).isEqualTo(count);
        assertTrue(userTablePage.listOfDescriptionOnUserTable.stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Field of description not found")).isDisplayed());
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        int listOfCheckboxesCount = userTablePage.listOfCheckboxOnUserTable.size();
        assertThat(listOfCheckboxesCount).isEqualTo(count);
        assertTrue(userTablePage.listOfCheckboxOnUserTable.stream()
                .findFirst().orElseThrow(() -> new RuntimeException("Field of checkbox not found")).isDisplayed());
    }

    @Then("User table should contain following values")
    public void tableContainValues(DataTable dataTable) {
        List<List<String>> userTable = dataTable.rows(1).cells();
        List<String> numbers = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> description = new ArrayList<>();
        userTable.forEach(e -> {
            numbers.add(e.get(0));
            names.add(e.get(1));
            description.add(e.get(2));
        });
        List<String> usersFromUserPage = userTablePage.listOfUsersOnUserTable
                .stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> numberFromUserPage = userTablePage.numberType
                .stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> descriptionFromUserPage = userTablePage.listOfDescriptionOnUserTable
                .stream().map(WebElement::getText).map(String::trim)
                .map(n -> n.replaceAll("\\s", " "))
                .map(String::trim).collect(Collectors.toList());
        assertThat(usersFromUserPage).isEqualTo(names);
        assertThat(numberFromUserPage).isEqualTo(numbers);
        assertThat(descriptionFromUserPage).isEqualTo(description);
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(DataTable dataForRoman) {
        List<String> dataFromTask = dataForRoman.asList();
        for (int i = 0; i < userTablePage.listOfDropDownForRoman.size(); i++) {
            assertThat(userTablePage.listOfDropDownForRoman.get(i).getText().equals(dataFromTask.get(i)));
        }
    }
}

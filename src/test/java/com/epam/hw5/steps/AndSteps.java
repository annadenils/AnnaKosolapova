package com.epam.hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;


import static com.epam.hw5.steps.BaseStep.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AndSteps {

    protected WebDriver driver;

    public AndSteps(WebDriver driver) {
        this.driver = driver;
    }
    @And("Check login and user name")
    public void checkLogin() {
        String userName = mainPage.getUserName().getText();
        assertEquals(userName, "ROMAN IOVLEV");
    }

    @And("Select checkbox {string}")
    public void selectCheckbox(String checkbox) {
        diffElementPage.checkbox
                .stream()
                .filter(element1 -> element1.getText().equals(checkbox)).findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Checkbox with name %s not found", checkbox)))
                .click();
        diffElementPage.checkbox.forEach(e -> assertTrue(e.isSelected()));
    }

    @And("Select radiobutton {string}")
    public void selectRadiobutton(String radiobutton) {
        diffElementPage.radiobutton
                .stream()
                .filter(element1 -> element1.getText().equals(radiobutton)).findFirst()
                .orElseThrow(() -> new RuntimeException(
                        String.format("Radiobutton with name %s not found", radiobutton)))
                .click();
        diffElementPage.radiobutton.forEach(e -> assertTrue(e.isSelected()));
    }

    @And("Select dropdown {string}")
    public void selectDropdown(String dropdown) {
        diffElementPage.dropdown
                .stream()
                .filter(element1 -> element1.getText().equals(dropdown)).findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Dropdown with name %s not found", dropdown)))
                .click();
        diffElementPage.dropdown.forEach(element -> assertTrue(element.isSelected()));
    }

    @And("Logs {string} is displayed")
    public void logsAreDisplayed(String logs) {
        diffElementPage.log.forEach(element -> assertTrue(element.isDisplayed()));
    }

    @And("I click on {string} button in Service dropdown")
    public void iClickOnButtonInServiceDropdown(String arg0) {
        headerPage.getListOfDropdownService()
                .stream()
                .filter(element1 -> element1.getText().equals(arg0))
                .findFirst().orElseThrow(() -> new RuntimeException(String.format("Group with name %s not found", arg0)))
                .click();
    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        int listOfDropdownTypeCount = userTablePage.getListOfDropdownTypeOnUserTable().size();
        assertThat(listOfDropdownTypeCount).isEqualTo(count);
        assertTrue(userTablePage.getListOfDropdownTypeOnUserTable()
                .stream().findFirst().orElseThrow(() -> new RuntimeException("dropdown not found")).isDisplayed());
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        int listOfUsersCount = userTablePage.listOfUsersOnUserTable.size();
        assertThat(listOfUsersCount).isEqualTo(count);
        assertTrue(userTablePage.listOfUsersOnUserTable.stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Field of users not found")).isDisplayed());
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        int listOfDescriptionCount = userTablePage.listOfDescriptionOnUserTable.size();
        assertThat(listOfDescriptionCount).isEqualTo(count);
        assertTrue(userTablePage.listOfDescriptionOnUserTable.stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Field of description not found")).isDisplayed());
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        int listOfCheckboxesCount = userTablePage.listOfCheckboxOnUserTable.size();
        assertThat(listOfCheckboxesCount).isEqualTo(count);
        assertTrue(userTablePage.listOfCheckboxOnUserTable.stream()
                .findFirst().orElseThrow(() -> new RuntimeException("Field of checkbox not found")).isDisplayed());
    }

    @And("User table should contain following values")
    public void tableContainValues(DataTable dataTable){
        List<String> numbers = dataTable.column(1);
        List<String> users = dataTable.column(2);
        List<String> description = dataTable.column(3);
        List<String> usersFromUserPage = userTablePage.listOfUsersOnUserTable
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(users).containsExactlyElementsOf(usersFromUserPage);
    }

    @And("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(DataTable dataForRoman) {
        List<String> dataFromTask = dataForRoman.column(1);
        List<String> dropdownForRoman = userTablePage.listOfDropDownForRoman
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(dataFromTask).containsExactlyElementsOf(dropdownForRoman);
    }
}

package com.epam.hw5.steps;


import com.epam.hw4.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class CucumberSteps extends Abstract {
    public static WebDriver driver;

    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";


    public CucumberSteps(WebDriver driver) {
//        this.driver = driver;
        super(driver);
    }

    public CucumberSteps(){
        super(driver);
    }


    @Given("Open website")
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Given("Page title is {string}")
    public void open_web_site_and_page_title_is_home_page(String browserTitle) {
        assertStep.browserTitle(browserTitle);
    }

    @When("Perform login")
    public void login() {
        actionStep.login();
    }

    @And("Check login and user name")
    public void checkLogin() {
        assertStep.assertLogin();
    }
    @When("Open Different Element Page")
    public void openDiffElementPage() {
        actionStep.clickDropdownServise();
        actionStep.clickDifferentElements();
    }

    @And("Select checkbox {string}")
    public void selectCheckbox(String checkbox) {
        actionStep.selectCheckbox(checkbox);
        assertStep.checkboxIsSelected(checkbox);
    }

//    @And("Select checkboxes {String}")
//    public void selectCheckbox(String checkbox) {
//        actionStep.selectCheckbox(checkbox);
//        assertStep.checkboxIsSelected("Water");
//        actionStep.selectCheckbox("Wind");
//        assertStep.checkboxIsSelected("Wind");
//    }

    @And("Select radiobutton {string}")
    public void selectRadiobutton(String radiobutton) {
        actionStep.radiobuttonSelect(radiobutton);
        assertStep.radiobuttonIsSelected(radiobutton);
    }

    @And("Select dropdown {string}")
    public void selectDropdown(String dropdown) {
        actionStep.selectFromDropdownInDiffElementsPage(dropdown);
        assertStep.dropdownIsSelected(dropdown);
    }

    @And("Logs {string} is displayed")
    public void logsAreDisplayed(String logs) {
        assertStep.checkLogText(logs);
    }

    @When("I click on Service button in Header")
    public void iClickOnButtonInHeader() {
        actionStep.clickDropdownServise();
    }

    @And("I click on {string} button in Service dropdown")
    public void iClickOnButtonInServiceDropdown(String arg0) {
        actionStep.selectFromDropdownService(arg0);
    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertStep.checkListOfDropdownTypeOnUserTable(count);
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertStep.checkListOfUsersOnUserTable(count);
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertStep.checkListOfDescriptionsOnUserTable(count);
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertStep.checkListOfCheckboxesOnUserTable(count);
    }

    @And("User table should contain following values")
    public void tableContainValues(DataTable dataTable){
        assertStep.userTableShouldContainFollowingValues(dataTable);
//    public void userTableShouldContainFollowingValues(DataTable dataTable) {
//        List<String> numbers = dataTable.column(1);
//        List<String> users = dataTable.column(2);
//        List<String> description = dataTable.column(3);
//        List<String> usersFromUserPage = BaseStep.userTablePage.listOfUsersOnUserTable
//                .stream().map(WebElement::getText).collect(Collectors.toList());
//        assertThat(users).containsExactlyElementsOf(usersFromUserPage);
    }

    @And("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(DataTable dataForRoman) {
        assertStep.checkDataAndDropdownForRoman(dataForRoman);
    }
}

package com.epam.hw5.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class CucumberSteps extends BaseStep {
    WebDriver driver;

//    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";


    public CucumberSteps(WebDriver driver) {
        this.driver = driver;
    }
//
//    public CucumberSteps(){
//        super(driver);
//    }


//    @Given("Open website")
//    public void setup() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        driver.get(URL);
//    }

    @Given("Page title is Home Page")
    public void open_web_site_and_page_title_is_home_page() {
        assertStep.browserTitle();
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

    @And("Select checkboxes Water and Wind")
    public void selectCheckbox() {
        actionStep.selectCheckbox("Water");
        assertStep.checkboxIsSelected("Water");
        actionStep.selectCheckbox("Wind");
        assertStep.checkboxIsSelected("Wind");
    }

    @And("Select radiobutton Selen")
    public void selectRadiobutton() {
        actionStep.radiobuttonSelect("Selen");
        assertStep.radiobuttonIsSelected("Selen");
    }

    @And("Select dropdown Yellow")
    public void selectDropdown() {
        actionStep.dropdownSelect("Yellow");
        assertStep.dropdownIsSelected("Yellow");
    }

    @And("Logs are displayed")
    public void logsAreDisplayed() {
        assertStep.checkLogText("Water: condition changed to true");
        assertStep.checkLogText("Wind: condition changed to true");
        assertStep.checkLogText("metal: value changed to Selen");
        assertStep.checkLogText("Colors: value changed to Yellow");
    }
}

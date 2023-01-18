package com.epam.hw5.steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.epam.hw5.steps.BaseStep.*;

public class WhenSteps{

    protected WebDriver driver;

    public WhenSteps(WebDriver driver) {
        this.driver = driver;
    }

    @When("Perform login")
    public void login() {
        mainPage.login("Roman", "Jdi1234");
    }

    @When("Open Different Element Page")
    public void openDiffElementPage() {
        headerPage.clickService();
        headerPage.clickDiffEl();
    }

    @When("I click on Service button in Header")
    public void iClickOnButtonInHeader() {
        headerPage.clickService();
    }

    @When("I select vip checkbox for {string}")
    public void iSelectVipCheckboxFor(String sergeyIvan) {
        if (sergeyIvan.toLowerCase().contains("sergey ivan")){
            userTablePage.listOfCheckboxOnUserTable.stream()
                    .filter(element1 -> element1.getText().equals("ivan"))
                    .findFirst().orElseThrow(() -> new RuntimeException("checkbox Vip not found"))
                    .click();
        }
    }

}

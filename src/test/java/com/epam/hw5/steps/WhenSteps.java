package com.epam.hw5.steps;

import io.cucumber.java.en.When;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HeaderPage;
import pages.MainPage;
import pages.UserTablePage;

public class WhenSteps extends BaseStep {

    protected WhenSteps(WebDriver driver) throws IOException {
        super(driver);
    }

    public WhenSteps() throws IOException {
        super(driver);
    }

    @When("Perform login")
    public void login() {
        mainPage = new MainPage(driver);
        mainPage.login("Roman", "Jdi1234");
    }

    @When("Open Different Element Page")
    public void openDiffElementPage() {
        headerPage = new HeaderPage(driver);
        headerPage.clickService();
        headerPage.clickDiffEl();
    }

    @When("I click on Service button in Header")
    public void clickOnButtonInHeader() {
        headerPage = new HeaderPage(driver);
        headerPage.clickService();
    }

    public void vipCheckBox(String checkBox) {
        By checkBoxElementPath = new By.ByXPath("//*[@id = '" + checkBox + "']");
        WebElement checkBoxValue = driver.findElement(checkBoxElementPath);
        checkBoxValue.click();
    }

    @When("I select vip checkbox for {string}")
    public void selectVipCheckboxFor(String sergeyIvan) {
        userTablePage = new UserTablePage(driver);
        if (sergeyIvan.toLowerCase().contains("sergey ivan")) {
            vipCheckBox("ivan");
        }
    }
}

package com.epam.hw4.steps;

import static com.epam.hw4.BaseTest.diffElementPage;
import static com.epam.hw4.BaseTest.headerPage;
import static com.epam.hw4.BaseTest.mainPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionSteps {
    private final WebDriver driver;

    public ActionSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Username is loggined")
    public void login() {
        mainPage.login("Roman", "Jdi1234");
    }

    @Step("switch to frame")
    public void switchToFrame() {
        driver.switchTo().frame("frame");
    }

    @Step("Switch to default content")
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    @Step("Dropdown Servise from header")
    public void clickDropdownServise() {
        headerPage.clickService();
    }

    @Step("Choose Different Elements")
    public void clickDifferentElements() {
        headerPage.clickDiffEl();
    }

    @Step("Select checkbox")
    public void selectCheckbox(String element) {
        diffElementPage.checkbox(element).click();
    }

    @Step("Select radio button")
    public void radiobuttonSelect(String element) {
        diffElementPage.radiobutton(element).click();
    }

    @Step("Select dropdown")
    public void dropdownSelect(String element) {
        diffElementPage.dropdown(element).click();
    }
}

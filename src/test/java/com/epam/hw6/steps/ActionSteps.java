package com.epam.hw6.steps;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.epam.hw6.BaseTest.*;

public class ActionSteps {
    protected WebDriver driver;

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
        diffElementPage.checkbox
                .stream()
                .filter(element1 -> element1.getText().equals(element))
                .findFirst().orElseThrow(() -> new RuntimeException("Checkbox with name " + element + " not found"))
                .click();
    }

    @Step("Select radio button")
    public void radiobuttonSelect(String element) {
        diffElementPage.radiobutton
                .stream()
                .filter(element1 -> element1.getText().equals(element))
                .findFirst().orElseThrow(() -> new RuntimeException("Radiobutton with name " + element + " not found"))
                .click();
    }

    @Step("Select dropdown")
    public void dropdownSelect(String element) {
        diffElementPage.dropdown
                .stream()
                .filter(element1 -> element1.getText().equals(element))
                .findFirst().orElseThrow(() -> new RuntimeException("Dropdown with name " + element + " not found"))
                .click();
    }
}

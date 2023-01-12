package com.epam.hw4.steps;

import static com.epam.hw4.BaseTest.diffElementPage;
import static com.epam.hw4.BaseTest.headerPage;
import static com.epam.hw4.BaseTest.mainPage;
import static com.epam.hw5.steps.BaseStep.userTablePage;

import com.epam.hw5.steps.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

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
        diffElementPage.getCheckbox()
                .stream()
                .filter(element1 -> element1.getText().equals(element))
                .findFirst().orElseThrow(() -> new RuntimeException("Checkbox with name " + element + " not found"))
                .click();
    }

    @Step("Select radio button")
    public void radiobuttonSelect(String element) {
        diffElementPage.getRadiobutton()
                .stream()
                .filter(element1 -> element1.getText().equals(element))
                .findFirst().orElseThrow(() -> new RuntimeException("Radiobutton with name " + element + " not found"))
                .click();
    }

    @Step("Select dropdown in Different Elements Page")
    public void selectFromDropdownInDiffElementsPage(String element) {
        diffElementPage.getDropdown()
                .stream()
                .filter(element1 -> element1.getText().equals(element))
                .findFirst().orElseThrow(() -> new RuntimeException("Dropdown with name " + element + " not found"))
                .click();
    }

    @Step("Select from dropdown Service subgroup")
    public void selectFromDropdownService(String element) {
        headerPage.getListOfDropdownService()
                .stream()
                .filter(element1 -> element1.getText().equals(element))
                .findFirst().orElseThrow(() -> new RuntimeException("Group with name " + element + " not found"))
                .click();
    }

    @Step("Select checkbox VIP for Sergey Ivan")
    public void selectCheckboxForSergeyIvan(String sergeyIvan) {
        if (sergeyIvan.toLowerCase().contains("sergey ivan")){
            userTablePage.listOfCheckboxOnUserTable.stream()
                    .filter(element1 -> element1.getText().equals("ivan"))
                    .findFirst().orElseThrow(() -> new RuntimeException("checkbox Vip not found"))
                    .click();
        }
    }
}

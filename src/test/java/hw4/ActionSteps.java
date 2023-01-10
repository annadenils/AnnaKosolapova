package hw4;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


public class ActionSteps extends InitialisationForHW4 {
    protected WebDriver driver;
    protected MainPage mainPage;
    protected DiffElementPage diffElementPage;
    protected HeaderPage headerPage;


    public ActionSteps(WebDriver driver) {
        this.driver = driver;
        mainPage = PageFactory.initElements(driver, MainPage.class);
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
    }

    SoftAssert softAssert = new SoftAssert();


    @Step("Username is loggined")
    public void login(){
        mainPage.login("Roman", "Jdi1234");
    }

    @Step("switch to frame")
    public void switchToFrame(){
        driver.switchTo().frame("frame");
    }

    @Step("Switch to default content")
    public void switchToDefault(){
        driver.switchTo().defaultContent();
    }

    @Step("Dropdown Servise from header")
    public void clickDropdownServise(){
        headerPage.clickService();
    }

    @Step("Choose Different Elements")
    public void clickDifferentElements(){
        headerPage.clickDiffEl();
    }


    @Step("Select checkbox")
    public void selectCheckbox(String element) {
        diffElementPage.getCheckbox()
                .stream()
                .filter(element1 -> element1.getText().equals(element))
                .findFirst().orElseThrow(()->new RuntimeException("Checkbox with name " + element + " not found"))
                .click();
    }

    @Step("Select radio button")
    public void radiobuttonSelect(String element){
        diffElementPage.getRadiobutton()
                .stream()
                .filter(element1 -> element1.getText().equals(element))
                .findFirst().orElseThrow(()-> new RuntimeException("Radiobutton with name " + element+ " not found"))
                .click();
    }

    @Step("Select dropdown")
    public void dropdownSelect(String element){
        diffElementPage.getDropdown()
                .stream()
                .filter(element1 -> element1.getText().equals(element))
                .findFirst().orElseThrow(()-> new RuntimeException("Dropdown with name " + element+ " not found"))
                .click();
    }
}

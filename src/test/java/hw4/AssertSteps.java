package hw4;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AssertSteps extends AbstractForHW4{

    protected WebDriver driver;
    protected MainPage mainPage;

    public static List<String> iconsText = List.of
            ("To include good practices\nand ideas from successful\nEPAM project",
                    "To be flexible and\ncustomizable", "To be multiplatform",
                    "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    public static List<String> iconsTextFail = List.of
            ("To include good practices\nand ideas from successful\nEPAM project",
                    "To be flexible and\ncustomizable ", "To be multiplatform ",
                    "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more… ");


    protected AssertSteps(WebDriver driver) {
        this.driver = driver;
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }
    SoftAssert softAssert = new SoftAssert();


    @Step("Assert Browser title")
    public void browserTitle(){
        softAssert.assertEquals(driver.getTitle(), "Home Page");
        softAssert.assertAll();
    }

    @Step("assertion login")
    public void assertLogin(){
        String userName = mainPage.getUserName().getText();
        softAssert.assertEquals(userName, "ROMAN IOVLEV");
        softAssert.assertAll();
    }

    @Step("Items in header")
    public void headerItems(){
        int headerCount = mainPage.headerName().size();
        softAssert.assertEquals(headerCount,4);
        for (int i = 0; i < headerCount; i++) {
            softAssert.assertEquals(mainPage.headerName().get(i).getText(), itemHeader.get(i));
            softAssert.assertTrue(mainPage.headerName().get(i).isDisplayed());
        }
        softAssert.assertAll();
    }


    @Step("Images on the Index Page")
    public void imagesIndexPage(){
        int iconsCount = mainPage.iconsItems().size();
        softAssert.assertEquals(iconsCount, 4);
        for (int y = 0; y < iconsCount; y++) {
            softAssert.assertTrue(mainPage.iconsItems().get(y).isDisplayed());
        }
        softAssert.assertAll();
    }

    @Step("Text under images on the Index Page")
    public void textUnderImagesPage(){
        int iconsTextCount = mainPage.iconsTextItems().size();
        softAssert.assertEquals(iconsTextCount, 4);
        for (int i = 0; i < iconsTextCount; i++) {
            softAssert.assertEquals(mainPage.iconsTextItems().get(i).getText(), iconsText.get(i));
            softAssert.assertTrue(mainPage.iconsTextItems().get(i).isDisplayed());
        }
        softAssert.assertAll();
    }
    @Step("Text under images on the Index Page (fail)")
    public void textUnderImagesPageFail(){
        int iconsTextCount = mainPage.iconsTextItems().size();
        softAssert.assertEquals(iconsTextCount, 4);
        for (int i = 0; i < iconsTextCount; i++) {
            softAssert.assertEquals(mainPage.iconsTextItems().get(i).getText(), iconsTextFail.get(i));
            softAssert.assertTrue(mainPage.iconsTextItems().get(i).isDisplayed());
        }
        softAssert.assertAll();
    }

    @Step("frame is displayed")
    public void frame(){
        softAssert.assertTrue(mainPage.frame.isDisplayed());
        softAssert.assertAll();
    }

    @Step("Frame button is displayed")
    public void frameButton(){
        softAssert.assertTrue(mainPage.frameButton.isDisplayed());
        softAssert.assertAll();
    }

    @Step("Items in the Left Section")
    public void itemsLeftSection(){
        int leftMenuCount = mainPage.leftMenuName().size();
        softAssert.assertEquals(leftMenuCount, 5);
        for (int i = 0; i < leftMenuCount; i++) {
            softAssert.assertEquals(mainPage.leftMenuName().get(i).getText(), itemLeftMenu.get(i));
            softAssert.assertTrue(mainPage.leftMenuName().get(i).isDisplayed());
        }
        softAssert.assertAll();
    }

    public void elementIsSelected(WebElement element) {
        Assertions.assertThat(element.isSelected()).isTrue();
    }

//    @Step("checkbox Water is selected")
//    public void checkboxWaterSelected(){
//        WebElement water = driver.findElement(By.xpath("//label[text()[contains(., ' Water')]]"));
//        softAssert.assertTrue(water.isSelected());
//    }
//
//    @Step("checkbox Wind is selected")
//    public void checkboxWindSelected(){
//        WebElement wind = driver.findElement(By.xpath("//label[text()[contains(., ' Wind')]]"));
//        softAssert.assertTrue(wind.isSelected());
//    }
//
//    @Step("Radio-button Selen is selected")
//    public void radiobuttonSelenSelected(){
//        WebElement selen = driver.findElement(By.xpath("//label[text()[contains(., ' Selen')]]"));
//        softAssert.assertTrue(selen.isSelected());
//    }
//
//    @Step("Drop-down Yellow is selected")
//    public void dropdownYellowSelected(){
//        WebElement yellow = driver.findElement(By.cssSelector("select > option:nth-child(4)"));
//        softAssert.assertTrue(yellow.isSelected());
//    }

    @Step("Check log")
    public void checkLog(){
        WebElement logWater = driver.findElement
                (By.xpath("//*[contains(text(),'Water: condition changed to true')]"));
        softAssert.assertTrue(logWater.isDisplayed());
        WebElement logWind = driver.findElement
                (By.xpath("//*[contains(text(),'Wind: condition changed to true')]"));
        softAssert.assertTrue(logWind.isDisplayed());
        WebElement logSelen = driver.findElement
                (By.xpath("//*[contains(text(),'metal: value changed to  Selen')]"));
        softAssert.assertTrue(logSelen.isDisplayed());
        WebElement logYellow = driver.findElement
                (By.xpath("//*[contains(text(),'Colors: value changed to Yellow')]"));
        softAssert.assertTrue(logYellow.isDisplayed());
    }
}

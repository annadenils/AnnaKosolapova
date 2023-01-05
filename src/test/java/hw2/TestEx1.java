package hw2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class TestEx1 extends ChromeTest{
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void TestsEx1(){
        homepage();
        login();
        checkHeader();
        checkIcons();
        checkIconsText();
        frameButton();
        checkLeftSection();
    }

    //step 2 - Assert Browser title
    public void homepage(){
        softAssert.assertEquals(driver.getTitle(), "Home Page");
    }

    //step 3 - Perform login
    //step 4 - Assert Username is loggined
    public void login(){
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
        WebElement loginname = driver.findElement(By.cssSelector("#user-name"));
        softAssert.assertEquals(loginname.getText(), "ROMAN IOVLEV");
    }

    //step 5 - Assert that there are 4 items on the header section are displayed, and they have proper texts

    public void checkHeader(){
        WebElement headerHome = driver.findElement(By.linkText("Home"));
        WebElement headerForm = driver.findElement(By.linkText("Contact form"));
        WebElement headerService = driver.findElement(By.linkText("Service"));
        WebElement headerMC = driver.findElement(By.linkText("Metals & Colors"));
        List<WebElement> headers = driver.findElements(By.cssSelector("ul[class='uui-navigation nav navbar-nav m-l8']>li"));
        int headerCount = headers.size();
        softAssert.assertEquals(headerCount, 4);
        softAssert.assertTrue(headerHome.isDisplayed());
        softAssert.assertTrue(headerForm.isDisplayed());
        softAssert.assertTrue(headerService.isDisplayed());
        softAssert.assertTrue(headerMC.isDisplayed());
    }

    //step 6 - Assert that there are 4 images on the Index Page, and they are displayed
    public void checkIcons(){
        List<WebElement> icons = driver.findElements(By.className("benefit-icon"));
        int iconCount = icons.size();
        softAssert.assertEquals(iconCount, 4);
        for (int i=0; i<iconCount; i++){
            softAssert.assertTrue(icons.get(i).isDisplayed());
        }
    }

    //step 7 - Assert that there are 4 texts on the Index Page under icons and they have proper text
    public void checkIconsText(){
        List<String> expText = List.of
                ("To include good practices\nand ideas from successful\nEPAM project",
                        "To be flexible and\ncustomizable ", "To be multiplatform ",
                        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        List<WebElement> curText = driver.findElements(By.className("benefit-icon"));
        softAssert.assertEquals(expText, curText);
        int textCount = curText.size();
        softAssert.assertEquals(textCount,4);
    }

    //step 8 - Assert that there is the iframe with “Frame Button” exist
    //step 9 - Switch to the iframe and check that there is “Frame Button” in the iframe
    //step 10 - Switch to original window back
    public void frameButton(){
        driver.switchTo().frame("frame");
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        softAssert.assertTrue(frameButton.isDisplayed());
        driver.switchTo().defaultContent();
    }

    //step 11 - Assert that there are 5 items in the Left Section are displayed, and they have proper text
    public void checkLeftSection() {
        List<String> itemLeftMenu = List.of
                ("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        List<WebElement> leftSection = driver.findElements(By.cssSelector("ul[class='sidebar-menu left']>li"));
        int leftSectionCount = leftSection.size();
        softAssert.assertEquals(leftSectionCount, 5);
        for (int i=0; i<leftSectionCount; i++){
            softAssert.assertEquals(leftSection.get(i).getText(), itemLeftMenu.get(i));
            softAssert.assertTrue(leftSection.get(i).isDisplayed());
        }
        softAssert.assertAll();
    }
}


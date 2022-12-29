package hw2;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEx1 extends ChromeTest{
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
        assertEquals(driver.getTitle(), "Home Page");
    }

    //step 3 - Perform login
    //step 4 - Assert Username is loggined
    public void login(){
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
        WebElement loginname = driver.findElement(By.cssSelector("#user-name"));
        assertEquals(loginname.getText(), "ROMAN IOVLEV");
    }

    //step 5 - Assert that there are 4 items on the header section are displayed, and they have proper texts

    @Rule
    public JUnitSoftAssertions softAssertions = new JUnitSoftAssertions();

    public void checkHeader(){
        WebElement headerHome = driver.findElement(By.linkText("Home"));
        WebElement headerForm = driver.findElement(By.linkText("Contact form"));
        WebElement headerService = driver.findElement(By.linkText("Service"));
        WebElement headerMC = driver.findElement(By.linkText("Metals & Colors"));
        List<WebElement> headers = driver.findElements(By.cssSelector("ul[class='uui-navigation nav navbar-nav m-l8']>li"));
        int headerCount = headers.size();
        assertThat(headerCount).isEqualTo(4);
        softAssertions.assertThat(headerHome.isDisplayed()).isTrue();
        softAssertions.assertThat(headerForm.isDisplayed()).isTrue();
        softAssertions.assertThat(headerService.isDisplayed()).isTrue();
        softAssertions.assertThat(headerMC.isDisplayed()).isTrue();
    }

    //step 6 - Assert that there are 4 images on the Index Page, and they are displayed
    public void checkIcons(){
        List<WebElement> icons = driver.findElements(By.className("benefit-icon"));
        int iconCount = icons.size();
        assertThat(iconCount).isEqualTo(4);
        for (int i=0; i<iconCount; i++){
            softAssertions.assertThat(icons.get(i).isDisplayed()).isTrue();
        }
    }

    //step 7 - Assert that there are 4 texts on the Index Page under icons and they have proper text
    public void checkIconsText(){
        List<String> expText = List.of
                ("To include good practices\nand ideas from successful\nEPAM project",
                        "To be flexible and\ncustomizable ", "To be multiplatform ",
                        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        List<WebElement> curText = driver.findElements(By.className("benefit-icon"));
        softAssertions.assertThat(expText).isEqualTo(curText);
        int textCount = curText.size();
        softAssertions.assertThat(textCount).isEqualTo(4);
    }

    //step 8 - Assert that there is the iframe with “Frame Button” exist
    //step 9 - Switch to the iframe and check that there is “Frame Button” in the iframe
    //step 10 - Switch to original window back
    public void frameButton(){
        driver.switchTo().frame("frame");
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        softAssertions.assertThat(frameButton.isDisplayed()).isTrue();
        driver.switchTo().defaultContent();
    }

    //step 11 - Assert that there are 5 items in the Left Section are displayed, and they have proper text
    public void checkLeftSection() {
        List<String> itemLeftMenu = List.of
                ("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        List<WebElement> leftSection = driver.findElements(By.cssSelector("ul[class='sidebar-menu left']>li"));
        int leftSectionCount = leftSection.size();
        softAssertions.assertThat(leftSectionCount).isEqualTo(5);
        for (int i=0; i<leftSectionCount; i++){
            softAssertions.assertThat(leftSection.get(i).getText()).isEqualTo(itemLeftMenu.get(i));
            softAssertions.assertThat(leftSection.get(i).isDisplayed()).isTrue();
        }
    }
}


package hw2;

import org.assertj.core.api.JUnitSoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

public class TestEx1 extends ChromeTest{

    @Test
    public void TestsEx1(){
        homepage();
        login();
        header();
        icons();
        iconsText();
        frameButton();
        leftSection();
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


    public void header(){
        WebElement headerHome = driver.findElement(By.linkText("Home"));
        WebElement headerForm = driver.findElement(By.linkText("Contact form"));
        WebElement headerService = driver.findElement(By.linkText("Service"));
        WebElement headerMC = driver.findElement(By.linkText("Metals & Colors"));
        List<WebElement> headers = driver.findElements(By.cssSelector("ul[class='uui-navigation nav navbar-nav m-l8']>li"));
        int headerCount = headers.size();
        assertThat(headerCount).isEqualTo(4);
        assertThat(headerHome.isDisplayed());
        assertThat(headerForm.isDisplayed());
        assertThat(headerService.isDisplayed());
        assertThat(headerMC.isDisplayed());
    }

    //step 6 - Assert that there are 4 images on the Index Page, and they are displayed
    public void icons(){
        WebElement iconPractice = driver.findElement(By.cssSelector(".benefits > div:nth-child(1) > div > div > span"));
        WebElement iconCustom = driver.findElement(By.cssSelector(".benefits > div:nth-child(2) > div > div > span"));
        WebElement iconMulti = driver.findElement(By.cssSelector(".benefits > div:nth-child(3) > div > div > span"));
        WebElement iconBase = driver.findElement(By.cssSelector(".benefits > div:nth-child(4) > div > div > span"));
        List<WebElement> icons = driver.findElements(By.className("benefit-icon"));
        int iconCount = icons.size();
        assertThat(iconCount).isEqualTo(4);
        iconPractice.isDisplayed();
        iconCustom.isDisplayed();
        assertThat(iconMulti.isDisplayed());
        assertThat(iconBase.isDisplayed());
    }

    //step 7 - Assert that there are 4 texts on the Index Page under icons and they have proper text
    public void iconsText(){
        List<String> expText = new ArrayList<>();
        expText.add("To include good practices\n" + "and ideas from successful\n" + "EPAM project");
        expText.add("To be flexible and\n" + "customizable ");
        expText.add("To be multiplatform ");
        expText.add("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n"
                + "wish to get more…");
        List<WebElement> curText = driver.findElements(By.className("benefit-icon"));
        assertThat(expText).isEqualTo(curText);
        int textCount = curText.size();
        assertThat(textCount).isEqualTo(4);
    }

    //step 8 - Assert that there is the iframe with “Frame Button” exist
    //step 9 - Switch to the iframe and check that there is “Frame Button” in the iframe
    //step 10 - Switch to original window back
    public void frameButton(){
        driver.switchTo().frame("frame");
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        frameButton.isDisplayed();
        driver.switchTo().defaultContent();
    }

    //step 11 - Assert that there are 5 items in the Left Section are displayed, and they have proper text
    public void leftSection() {
        WebElement leftHome = driver.findElement(By.cssSelector("ul > li:nth-child(1)"));
        WebElement leftContact = driver.findElement
                (By.xpath("//*/ul[@class=\"sidebar-menu left\"]/li[2]"));
        WebElement leftService = driver.findElement(By.cssSelector("ul > li:nth-child(3)"));
        WebElement leftMC = driver.findElement(By.xpath("//*/ul[@class=\"sidebar-menu left\"]/li[4]"));
        WebElement leftElement = driver.findElement
                (By.cssSelector("ul > li:nth-child(5)"));
        List<WebElement> leftSection = driver.findElements(By.cssSelector("ul[class='sidebar-menu left']>li"));
        int leftSectionCount = leftSection.size();
        assertThat(leftSectionCount).isEqualTo(5);
        leftHome.isDisplayed();
        leftContact.isDisplayed();
        leftService.isDisplayed();
        leftMC.isDisplayed();
        leftElement.isDisplayed();
        assertThat(leftHome).isEqualTo("Home");
        assertThat(leftContact).isEqualTo("Contact form");
        assertThat(leftService).isEqualTo("Service");
        assertThat(leftMC).isEqualTo("Metals & Colors");
        assertThat(leftElement).isEqualTo("Elements packs");
    }

}


package hw2;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEx2 extends ChromeTest{
    @Rule
    public JUnitSoftAssertions softAssertions = new JUnitSoftAssertions();

    @Test
    public void TestsEx2(){
        homepage();
        login();
        checkDifElements();
        checkboxWaterWind();
        buttonSelen();
        dropdownYellow();
        checkLog();
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

    //step 5 - Open through the header menu Service -> Different Elements Page
    public void checkDifElements(){
        driver.findElement(By.className("dropdown-toggle")).click();
        driver.findElement(By.partialLinkText("DIFFERENT ELEMENTS")).click();
        assertEquals(driver.getTitle(), "Different Elements");
    }

    //step 6 - Select checkboxes Water, Wind
    public void checkboxWaterWind(){
        WebElement water = driver.findElement(By.xpath("//label[text()[contains(., ' Water')]]"));
        water.click();
        softAssertions.assertThat(water.isSelected()).isTrue();
        WebElement wind = driver.findElement(By.xpath("//label[text()[contains(., ' Wind')]]"));
        wind.click();
        softAssertions.assertThat(wind.isSelected()).isTrue();
    }

    //step 7 - Select radio Selen
    public void buttonSelen(){
        WebElement selen = driver.findElement(By.xpath("//label[text()[contains(., ' Selen')]]"));
        selen.click();
        softAssertions.assertThat(selen.isSelected()).isTrue();
    }

    //step 8 - Select in dropdown Yellow
    public void dropdownYellow(){
        WebElement yellow = driver.findElement(By.cssSelector("select > option:nth-child(4)"));
        yellow.click();
        softAssertions.assertThat(yellow.isSelected()).isTrue();

    }

    //step 9 -Assert that
    //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    //• for radio button there is a log row and value is corresponded to the status of radio button
    //• for dropdown there is a log row and value is corresponded to the selected value.
    public void checkLog(){
        WebElement logWater = driver.findElement
                (By.xpath("//*[contains(text(),'Water: condition changed to true')]"));
        softAssertions.assertThat(logWater.isDisplayed()).isTrue();
        WebElement logWind = driver.findElement
                (By.xpath("//*[contains(text(),'Wind: condition changed to true')]"));
        softAssertions.assertThat(logWind.isDisplayed()).isTrue();
        WebElement logSelen = driver.findElement
                (By.xpath("//*[contains(text(),'metal: value changed to  Selen')]"));
        softAssertions.assertThat(logSelen.isDisplayed()).isTrue();
        WebElement logYellow = driver.findElement
                (By.xpath("//*[contains(text(),'Colors: value changed to Yellow')]"));
        softAssertions.assertThat(logYellow.isDisplayed()).isTrue();
    }
}

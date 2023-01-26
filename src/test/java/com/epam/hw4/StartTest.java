package com.epam.hw4;

import com.epam.hw4.steps.ActionsSteps;
import com.epam.hw4.steps.AssertionSteps;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DiffElementPage;
import pages.HeaderPage;
import pages.MainPage;

public class StartTest {

    WebDriver driver;
    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public static ActionsSteps actionStep;
    public static AssertionSteps assertStep;
    public static MainPage mainPage;
    public static HeaderPage headerPage;
    public static DiffElementPage diffElementPage;

    @BeforeMethod
    public void setup(ITestContext testContext) {
        driver = new ChromeDriver();
        testContext.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(URL);
        assertStep = new AssertionSteps(driver);
        actionStep = new ActionsSteps(driver);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        diffElementPage = PageFactory.initElements(driver, DiffElementPage.class);
    }

    @AfterMethod
    void end() {
        if (driver != null) {
            driver.quit();
        }
    }
}


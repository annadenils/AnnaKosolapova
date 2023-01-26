package com.epam.hw6;

import com.epam.hw6.steps.ActionSteps;
import com.epam.hw6.steps.AssertSteps;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.DiffElementPage;
import pages.HeaderPage;
import pages.MainPage;

public class BaseTest {

    WebDriver driver;
    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public static ActionSteps actionStep;
    public static AssertSteps assertStep;
    public static MainPage mainPage;
    public static HeaderPage headerPage;
    public static DiffElementPage diffElementPage;

    @BeforeClass
    @Parameters({"isLocal", "hub", "browser"})
    public void beforeClass(@Optional("false") final boolean isLocal, final String hub, String browser) {
        driver = DriverFabric.getWebDriver(isLocal, hub, browser);
    }

    @BeforeMethod
    public void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(URL);
        assertStep = new AssertSteps(driver);
        actionStep = new ActionSteps(driver);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        diffElementPage = PageFactory.initElements(driver, DiffElementPage.class);
    }

    @AfterClass(alwaysRun = true)
    void end() {
        if (driver != null) {
            driver.quit();
        }
    }
}


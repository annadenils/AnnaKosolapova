package com.epam.hw5.steps;

import com.epam.hw4.steps.ActionSteps;
import com.epam.hw4.steps.AssertSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.DiffElementPage;
import pages.HeaderPage;
import pages.MainPage;
import pages.UserTablePage;

import java.util.concurrent.TimeUnit;

public class BaseStep {
    WebDriver driver;
    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public static MainPage mainPage;
    public static HeaderPage headerPage;
    public static DiffElementPage diffElementPage;
    public static UserTablePage userTablePage;


    @BeforeTest
    public void before_or_after(ITestContext testContext) {
        driver = new ChromeDriver();
        testContext.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(URL);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        diffElementPage = PageFactory.initElements(driver, DiffElementPage.class);
        userTablePage = PageFactory.initElements(driver, UserTablePage.class);
    }

    @AfterTest
    void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}

package com.epam.hw2;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class ChromeTest {

    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    public WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = WebDriverManager.chromedriver().create();
    }

    @BeforeMethod
    public void setUp() {
        driver.get(URL);
    }

    @AfterClass
    void teardown() {
        driver.quit();
    }
}

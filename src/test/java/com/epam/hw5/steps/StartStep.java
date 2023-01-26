package com.epam.hw5.steps;

import static com.epam.hw5.steps.BaseStep.driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class StartStep {
    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @After()
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}

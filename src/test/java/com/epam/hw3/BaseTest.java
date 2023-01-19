package com.epam.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DiffElementPage;
import pages.HeaderPage;
import pages.MainPage;

import static org.openqa.selenium.support.PageFactory.initElements;

public class BaseTest {
        public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
        WebDriver driver;
        public static MainPage mainPage;
        public static HeaderPage headerPage;
        public static DiffElementPage diffElementPage;

        @BeforeMethod
        public void setup() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(URL);
            mainPage = initElements(driver, MainPage.class);
            headerPage = initElements(driver, HeaderPage.class);
            diffElementPage = initElements(driver, DiffElementPage.class);
        }

        @AfterMethod
        void end() {
            if (driver != null) {
                driver.quit();
            }
        }
}


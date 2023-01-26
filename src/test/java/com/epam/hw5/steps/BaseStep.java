package com.epam.hw5.steps;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import pages.DiffElementPage;
import pages.HeaderPage;
import pages.MainPage;
import pages.UserTablePage;

public class BaseStep {

    public static WebDriver driver;
    public static MainPage mainPage;
    public static HeaderPage headerPage;
    public static DiffElementPage diffElementPage;
    public static UserTablePage userTablePage;

    protected BaseStep(WebDriver driver) throws IOException {}

    public BaseStep() throws IOException {}

    static void openWebSite(String website) {
        driver.get(website);
    }
}

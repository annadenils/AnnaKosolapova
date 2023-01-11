package com.epam.hw5.steps;

import com.epam.hw4.steps.ActionSteps;
import com.epam.hw4.steps.AssertSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.DiffElementPage;
import pages.HeaderPage;
import pages.MainPage;

public class Abstract {
    public static WebDriver driver;

    public static ActionSteps actionStep;
    public static AssertSteps assertStep;

    protected Abstract(WebDriver driver){
        Abstract.driver = driver;
        assertStep = new AssertSteps(driver);
        actionStep = new ActionSteps(driver);
    }
}

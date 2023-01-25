package com.epam.hw5.steps;

import static com.epam.hw5.steps.BaseStep.openWebSite;
import static com.epam.hw5.steps.StartStep.URL;

import io.cucumber.java.en.Given;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

public class GivenSteps {
    public GivenSteps(WebDriver driver) throws IOException {
    }

    public GivenSteps() throws IOException {}

    @Given("Open website")
    public void open_website() {
        openWebSite(URL);
    }

}

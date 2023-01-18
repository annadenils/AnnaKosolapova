package com.epam.hw5.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class GivenSteps{

    public WebDriver driver;

    public GivenSteps(WebDriver driver1) {
        this.driver = driver1;
    }
    @Given("Page title is {string}")
    public void open_web_site_and_page_title_is_home_page(String browserTitle) {
        assertThat(driver.getTitle()).isEqualTo(browserTitle);
    }

}

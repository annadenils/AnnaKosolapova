package com.epam.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature",
        glue = {"com/epam/hw5/steps"},
        publish = true)

public class RunCucumberTest extends AbstractTestNGCucumberTests {
}

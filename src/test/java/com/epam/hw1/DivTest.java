package com.epam.hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivTest extends StartTest {
    @DataProvider
    public static Object[][] divData() {
        return new Object[][]{
                {6.0, 2.0, 3.0},
                {40.0, 4.0, 10.0},
                {45.0, 5.0, 9.0}};
    }

    @Test(dataProvider = "divData")
    public void divTest(double t, double u, double result) {
        double act = calculator.div(t, u);
        Assert.assertEquals(act, result, 0.0001);
    }
}

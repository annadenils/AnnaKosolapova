package com.epam.hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultTest extends StartTest{

    @DataProvider
    public static Object[][] multData(){
        return new Object[][]{
                {2.0, 5.0, 10.0},
                {3.0, 15.0, 45.0},
                {4.0, 4.0, 16.0}
        };
    }

    @Test(dataProvider = "multData")
    public void multTest(double x, double y, double result){
        double act = calculator.mult(x,y);
        Assert.assertEquals(act, result, 0.0001);
    }

}

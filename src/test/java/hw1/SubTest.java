package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubTest extends StartTest{
    @DataProvider
    public static Object[][] subData(){
        return new Object[][]{
                {7.0, 4.0, 3.0},
                {67.0, 15.0, 52.0},
                {568.0, 54.0, 514.0}
        };
    }

    @Test(dataProvider = "subData")
    public void subTest(double d, double c, double result){
        double act = calculator.sub(d,c);
        Assert.assertEquals(act, result, 0.0001);
    }
}

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest extends StartTest{

    @DataProvider
    public static Object[][] sumData(){
        return new Object[][]{
                {10.0, 2.0, 12.0},
                {5.0, 0.0, 5.0}
        };
    };

    @Test(dataProvider = "sumData")
    public void sumTest(double a, double b, double result){
        var act = calculator.sum(a, b);
        Assert.assertEquals(act, result, 0.0001);
    }
}

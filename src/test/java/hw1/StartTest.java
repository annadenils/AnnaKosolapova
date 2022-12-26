package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

public class StartTest {

    protected Calculator calculator;

    @BeforeMethod
    public void before(){
        calculator = new Calculator();
    }

    @AfterMethod
    public void after(){
        calculator = null;
    }

}

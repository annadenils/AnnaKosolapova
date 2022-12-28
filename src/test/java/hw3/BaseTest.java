package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

class BaseTest {

    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new DriverManager().setupDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void setUp(){
        driver.get(URL);
    }

    @AfterClass
    void teardown() {
        driver.quit();
    }
}

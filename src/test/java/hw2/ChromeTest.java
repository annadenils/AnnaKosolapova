package hw2;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.List;


public class ChromeTest {

//    WebDriver driver;
//
//    @BeforeClass
//    void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        String url = "https://jdi-testing.github.io/jdi-light/index.html";
//        driver.get(url);
//    }
//
//    @AfterClass
//    void teardown() {
//        driver.quit();
//    }

    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    public WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = WebDriverManager.chromedriver().create();
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

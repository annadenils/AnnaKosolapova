package hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

class ChromeTest {
    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void setUp(){
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterClass
    void teardown() {
        driver.quit();
    }
}

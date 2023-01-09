package hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class InitialisationForHW4 {

    WebDriver driver;
    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    ActionSteps actionStep;
    AssertSteps assertStep;


    public static List<String> itemHeader = List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    public static List<String> itemLeftMenu = List.of
            ("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

    @BeforeMethod
    public void setup(ITestContext iTestContext){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        iTestContext.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(URL);
        assertStep = new AssertSteps(driver);
        actionStep = new ActionSteps(driver);
    }

    @AfterMethod
    void end() {
        driver.quit();
        driver = null;
    }
}


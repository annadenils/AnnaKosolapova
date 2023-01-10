package hw4;

import hw4.steps.ActionSteps;
import hw4.steps.AssertSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DiffElementPage;
import pages.HeaderPage;
import pages.MainPage;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    WebDriver driver;
    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public static ActionSteps actionStep;
    public static AssertSteps assertStep;
    public static MainPage mainPage;
    public static HeaderPage headerPage;
    public static DiffElementPage diffElementPage;

    @BeforeMethod
    public void setup(ITestContext iTestContext){
        driver = new ChromeDriver();
        iTestContext.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(URL);
        assertStep = new AssertSteps(driver);
        actionStep = new ActionSteps(driver);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        diffElementPage = PageFactory.initElements(driver, DiffElementPage.class);
    }

    @AfterMethod
    void end() {
        if (driver != null){
        driver.quit();}
    }
}


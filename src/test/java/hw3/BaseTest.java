package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DiffElementPage;
import pages.HeaderPage;
import pages.MainPage;

public class BaseTest {
        public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
        public WebDriver driver;
        public static MainPage mainPage;
        public static HeaderPage headerPage;
        public static DiffElementPage diffElementPage;

        @BeforeMethod
        public void setup() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(URL);
            mainPage = PageFactory.initElements(driver, MainPage.class);
            headerPage = PageFactory.initElements(driver, HeaderPage.class);
            diffElementPage = PageFactory.initElements(driver, DiffElementPage.class);
        }

        @AfterMethod
        void end() {
            if(driver != null){
            driver.quit();
            }
        }
    }


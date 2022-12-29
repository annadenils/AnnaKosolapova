package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractClass {
        public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
        public WebDriver driver;

        public static List<String> itemHeader = List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        public static List<String> itemLeftMenu = List.of
                ("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

        @BeforeClass
        public void start(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @BeforeMethod
        public void setup(){
            driver.get(URL);
        }

        @AfterClass
        void end() {
            driver.quit();
        }
    }


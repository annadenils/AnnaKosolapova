package hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class AbstractForHW4{
    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    public WebDriver driver;

    public static List<String> itemHeader = List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    public static List<String> itemLeftMenu = List.of
            ("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    void end() {
        driver.quit();
    }
}


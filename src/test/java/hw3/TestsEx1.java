package hw3;

import hw2.ChromeTest;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestsEx1 extends ChromeTest {
    public static WebDriver driver;

    @Test
    public void test3() {
     login();
    }

    @Rule
    public JUnitSoftAssertions softAssertions = new JUnitSoftAssertions();

    public void login(){
//        LoginPage loginPage = new LoginPage();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login("Roman", "Jdi1234");
        String userName = loginPage.getUserName().getText();
        softAssertions.assertThat(userName).isEqualTo("ROMAN IOVLEV");
//        LoginPage.using(driver).LoginIcon();
    }
}

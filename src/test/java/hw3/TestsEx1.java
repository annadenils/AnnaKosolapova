package hw3;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestsEx1 extends BaseTest {
    public static WebDriver driver;

    @Test
    public void test3() {
     login();
    }

    @Rule
    public JUnitSoftAssertions softAssertions = new JUnitSoftAssertions();

    public void login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Roman", "Jdi1234");
        String userName = loginPage.getUserName().getText();
        softAssertions.assertThat(userName).isEqualTo("ROMAN IOVLEV");
//        LoginPage.using(driver).LoginIcon();
    }
}

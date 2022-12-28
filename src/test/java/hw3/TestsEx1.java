package hw3;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertEquals;

public class TestsEx1 extends DriverTest{
    public static LoginPage loginPage;

    @Test
    public void test3() {
        homepage();
        login();
    }
    public void homepage(){
        assertEquals(driver.getTitle(), "Home Page");
    }

    @Rule
    public JUnitSoftAssertions softAssertions = new JUnitSoftAssertions();


    public void login(){
        loginPage.login("Roman", "Jdi1234");
        String userName = loginPage.getUserName().getText();
        softAssertions.assertThat(userName).isEqualTo("ROMAN IOVLEV");
    }
}

package hw3;

import Pages.DiffElementsPage;
import Pages.HeaderPage;
import Pages.MainPage;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex2Test extends AbstractClass{
    @Rule
    public JUnitSoftAssertions softAssertions = new JUnitSoftAssertions();

    @Test
    public void ex2Tests() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        HeaderPage headerPage = PageFactory.initElements(driver, HeaderPage.class);
        DiffElementsPage diffElementsPage = PageFactory.initElements(driver, DiffElementsPage.class);
        //step 2 - Assert Browser title
        Assertions.assertEquals(driver.getTitle(), "Home Page");

        //step 3 - Perform login
        //step 4 - Assert Username is loggined
        mainPage.login("Roman", "Jdi1234");
        String userName = mainPage.getUserName().getText();
        softAssertions.assertThat(userName).isEqualTo("ROMAN IOVLEV");

        //step 5 - Open through the header menu Service -> Different Elements Page
        headerPage.clickService();
        headerPage.clickDiffEl();

        //step 6 - Select checkboxes Water, Wind
        diffElementsPage.clickWater();
        softAssertions.assertThat(diffElementsPage.water.isSelected()).isTrue();
        diffElementsPage.clickWind();
        softAssertions.assertThat(diffElementsPage.wind.isSelected()).isTrue();

        //step 7 - Select radio Selen
        diffElementsPage.clickSelen();
        softAssertions.assertThat(diffElementsPage.selen.isSelected()).isTrue();

        //step 8 - Select in dropdown Yellow
        diffElementsPage.setYellow();
        softAssertions.assertThat(diffElementsPage.yellow.isSelected()).isTrue();

        //step 9 -Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //• for radio button there is a log row and value is corresponded to the status of radio button
        //• for dropdown there is a log row and value is corresponded to the selected value.
        assertTrue(diffElementsPage.logWater.isDisplayed());
        assertTrue(diffElementsPage.logWind.isDisplayed());
        assertTrue(diffElementsPage.logSelen.isDisplayed());
        assertTrue(diffElementsPage.logYellow.isDisplayed());
    }
}

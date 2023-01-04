package hw4;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Task1ForHW4 extends AbstractForHW4{
    public static List<String> iconsText = List.of
            ("To include good practices\nand ideas from successful\nEPAM project",
                    "To be flexible and\ncustomizable ", "To be multiplatform ",
                    "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    @Rule
    public JUnitSoftAssertions softAssertions = new JUnitSoftAssertions();

    @Test
    @Feature("ex1")
    @Story("main page")
    public void Task1HW4() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        //step 2 - Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //step 3 - Perform login
        //step 4 - Assert Username is loggined
        mainPage.login("Roman", "Jdi1234");
        String userName = mainPage.getUserName().getText();
        softAssertions.assertThat(userName).isEqualTo("ROMAN IOVLEV");

        //step 5 - Assert that there are 4 items on the header section are displayed, and they have proper texts
        int headerCount = mainPage.headerName().size();
        assertThat(headerCount).isEqualTo(4);
        for (int i = 0; i < headerCount; i++) {
            softAssertions.assertThat(mainPage.headerName().get(i).getText()).isEqualTo(itemHeader.get(i));
            assertTrue(mainPage.headerName().get(i).isDisplayed());
        }

        //step 6 - Assert that there are 4 images on the Index Page, and they are displayed
        int iconsCount = mainPage.iconsItems().size();
        assertThat(iconsCount).isEqualTo(4);
        for (int y = 0; y < iconsCount; y++) {
            assertTrue(mainPage.iconsItems().get(y).isDisplayed());
        }

        //step 7 - Assert that there are 4 texts on the Index Page under icons, and they have proper text
        int iconsTextCount = mainPage.iconsTextItems().size();
        assertThat(iconsTextCount).isEqualTo(4);
        for (int i = 0; i < iconsTextCount; i++) {
            softAssertions.assertThat(mainPage.iconsTextItems().get(i).getText()).isEqualTo(iconsText.get(i));
            assertTrue(mainPage.iconsTextItems().get(i).isDisplayed());
        }

        //step 8 - Assert that there is the iframe with “Frame Button” exist
        //step 9 - Switch to the iframe and check that there is “Frame Button” in the iframe
        //step 10 - Switch to original window back
        assertTrue(mainPage.frame.isDisplayed());
        driver.switchTo().frame("frame");
        assertTrue(mainPage.frameButton.isDisplayed());
        driver.switchTo().defaultContent();

        //step 11 - Assert that there are 5 items in the Left Section are displayed, and they have proper text
        int leftMenuCount = mainPage.leftMenuName().size();
        assertThat(leftMenuCount).isEqualTo(5);
        for (int i = 0; i < leftMenuCount; i++) {
            softAssertions.assertThat(mainPage.leftMenuName().get(i).getText()).isEqualTo(itemLeftMenu.get(i));
            assertTrue(mainPage.leftMenuName().get(i).isDisplayed());
        }
    }
}

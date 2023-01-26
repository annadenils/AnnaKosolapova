package com.epam.hw7;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import jdi.DataMetalsColors;
import jdi.JDiSite;
import jdi.objects.MetalsColors;
import jdi.objects.User;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JDiTest {

    public static final User ROMAN = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JDiSite.class, "chrome");
        JDiSite.openHomepage();
        JDiSite.login(ROMAN);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(dataProvider = "dataMetalsColors", dataProviderClass = DataMetalsColors.class)
    public void jdiTest(MetalsColors metalsColors) {
        JDiSite.getUserName(ROMAN.getFullName());
        JDiSite.openMetalsColorsPage();
        JDiSite.jDiMetalsColorPage.fillMetalColorsForm(metalsColors);
        JDiSite.checkResultOfLogs(metalsColors);
    }
}

package com.epam.hw7;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import jdi.JDiSite;
import jdi.objects.User;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JDITest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        PageFactory.initSite(JDiSite.class, "chrome");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test
    public void jdiTest(){
        JDiSite.openHomepage();
        JDiSite.login(User.ROMAN);
        JDiSite.getUserName();
        JDiSite.openMetalsColorsPage();
    }
}

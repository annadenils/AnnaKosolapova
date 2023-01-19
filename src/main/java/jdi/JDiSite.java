package jdi;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import jdi.objects.MetalsColors;
import jdi.objects.User;
import jdi.pages.JDiHomepage;
import jdi.pages.JDiMetalsColorPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JDiSite {

    @Url("/index.html")
    public static JDiHomepage jDiHomepage;

    @Url("/metals-colors.html")
    public static JDiMetalsColorPage jDiMetalsColorPage;

    public static void openHomepage() {
        jDiHomepage.open();
    }

    public static void login(User user) {
        jDiHomepage.login(user);
    }

    public static String getUserName() {
        return jDiHomepage.userName();
    }

    public static void openMetalsColorsPage() {
        jDiMetalsColorPage.open();
    }

    public static void checkResultOfLogs(MetalsColors metalsColors) {
        jDiMetalsColorPage.checkLogAfterFill(metalsColors);
    }
}

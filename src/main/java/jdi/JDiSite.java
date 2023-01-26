package jdi;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import jdi.objects.MetalsColors;
import jdi.objects.User;
import jdi.pages.JDiHomepage;
import jdi.pages.JDiMetalsColorPage;

import static org.assertj.core.api.Assertions.assertThat;

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

    public static void getUserName(String userName) {
        assertThat(jDiHomepage.userName()).isEqualTo(userName);
    }

    public static void openMetalsColorsPage() {
        jDiMetalsColorPage.open();
    }

    public static void checkResultOfLogs(MetalsColors metalsColors) {
        jDiMetalsColorPage.assertResultLog(metalsColors);
    }
}

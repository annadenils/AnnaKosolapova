package jdi.pages;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import java.util.List;
import java.util.stream.Collectors;
import jdi.forms.MetalsColorsForm;
import jdi.objects.MetalsColors;
import org.openqa.selenium.WebElement;


public class JDiMetalsColorPage extends WebPage {

    public MetalsColorsForm metalsColorsForm;

    public void fillMetalColorsForm(MetalsColors metalsColors) {
        metalsColorsForm.fill(metalsColors);
    }

    @Css(".results li")
    private WebList logsFromPage;

    public void assertResultLog(MetalsColors metalsColors) {
        List<String> actualLogsFromPage = logsFromPage.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> metalColorsLogs = metalsColors.getLog();
        assertThat(actualLogsFromPage).containsAll(metalColorsLogs);
    }

}

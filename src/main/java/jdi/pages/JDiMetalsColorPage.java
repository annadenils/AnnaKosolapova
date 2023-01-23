package jdi.pages;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import jdi.forms.MetalsColorsForm;
import jdi.objects.MetalsColors;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class JDiMetalsColorPage extends WebPage {

    public MetalsColorsForm metalsColorsForm;

    public void fillMetalColorsForm(MetalsColors metalsColors) {
        metalsColorsForm.setForm(metalsColors);
    }

    @Css(".results li")
    private WebList log;

    public void checkLogAfterFill(MetalsColors metalsColors) {
        List<String> actLog = log.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> log1 = metalsColors.getLog();
        assertThat(actLog).containsAll(log1);
    }

}

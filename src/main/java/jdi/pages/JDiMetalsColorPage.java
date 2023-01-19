package jdi.pages;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import jdi.forms.MetalsColorsForm;
import jdi.objects.MetalsColors;
import java.util.ArrayList;
import java.util.List;

public class JDiMetalsColorPage extends WebPage {

    public MetalsColorsForm metalsColorsForm;

    public void fillMetalColorsForm(MetalsColors metalsColors) {
        metalsColorsForm.setForm(metalsColors);
    }

    @Css(".results li")
    private WebList log;

    public List<String> actualLog() {
        List<String> result = new ArrayList<>();
        log.forEach(els -> {
            result.add(els.getText());
        });
        return result;
    }

    public void checkLogAfterFill(MetalsColors metalsColors) {
        assertThat(metalsColors.getLog()).hasSameElementsAs(actualLog());
    }

}

package jdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import jdi.forms.MetalsColorsForm;
import jdi.objects.MetalsColors;

public class JDiMetalsColorPage extends WebPage {

    public MetalsColorsForm metalsColorsForm;

    public void fillMetalColorsForm(MetalsColors metalsColors) {
        metalsColorsForm.setForm(metalsColors);
    }
}

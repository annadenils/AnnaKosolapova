package jdi.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import jdi.objects.MetalsColors;

public class MetalsColorsForm extends Form<MetalsColorsForm> {

    @FindBy(css = "#elements-checklist input")
    public Checklist element;

    @FindBy(name = "custom_radio_odd")
    private RadioButtons oddNumbers;

    @FindBy(name = "custom_radio_even")
    private RadioButtons evenNumbers;

    @JDropdown(root = "#colors", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown colors;

    @JDropdown(root = "#metals", value = ".form-option", list = "li", expand = ".caret")
    private Dropdown metals;

    @FindBy(id = "salad-dropdown")
    private Button salad;

    @FindBy(css = "#salad-dropdown  input")
    private Checklist saladList;

    @FindBy(id = "submit-button")
    private Button submit;

    public void setForm(MetalsColors metalsColors) {
        oddNumbers.select(metalsColors.summary.get(0));
        evenNumbers.select(metalsColors.summary.get(1));
        metalsColors.getElement().forEach(element::select);
        colors.select(metalsColors.color);
        metals.select(metalsColors.metal);
        salad.click();
        saladList.select("Vegetables");
        metalsColors.getVegetable().forEach(saladList::select);
        submit.click();
    }

}

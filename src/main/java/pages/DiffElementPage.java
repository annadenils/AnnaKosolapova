package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DiffElementPage {

    @FindBy(className = "label-checkbox")
    public List<WebElement> checkbox;

    @FindBy(className = "label-radio")
    public List<WebElement> radiobutton;

    @FindBy(css = ".colors>select > option")
    public List<WebElement> dropdown;

    @FindBy(css = ".panel-body-list.logs")
    public List<WebElement> log;

    public WebElement getCheckbox(String nameCheckbox) {
        return checkbox.stream().filter(element1 -> element1.getText().equals(nameCheckbox)).findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Checkbox with name %s not found", nameCheckbox)));
    }

    public WebElement getRadiobutton(String nameRadiobutton) {
        return radiobutton.stream().filter(element1 -> element1.getText().equals(nameRadiobutton)).findFirst()
                .orElseThrow(() -> new RuntimeException
                        (String.format("Radiobutton with name %s not found", nameRadiobutton)));
    }

    public WebElement getDropdown(String nameDropdown) {
        return dropdown.stream().filter(element1 -> element1.getText().equals(nameDropdown)).findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Dropdown with name %s not found", nameDropdown)));
    }

}

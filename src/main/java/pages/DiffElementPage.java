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

    public List<WebElement> getCheckbox() {
        return checkbox;
    }

    public List<WebElement> getRadiobutton() {
        return radiobutton;
    }

    public List<WebElement> getDropdown() {
        return dropdown;
    }

    public List<WebElement> getLog() {
        return log;
    }

}

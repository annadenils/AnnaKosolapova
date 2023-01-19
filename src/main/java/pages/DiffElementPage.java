package pages;

import static java.lang.String.format;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class DiffElementPage {

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkbox;

    @FindBy(className = "label-radio")
    private List<WebElement> radiobutton;

    @FindBy(css = ".colors>select > option")
    private List<WebElement> dropdown;

    @FindBy(css = ".panel-body-list.logs")
    private List<WebElement> log;

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

    public WebElement checkbox(String nameCheckbox) {
        return getCheckbox().stream().filter(element1 -> element1.getText().equals(nameCheckbox))
                .findFirst().orElseThrow(() -> new RuntimeException(format("Checkbox with name %s not found",
                        nameCheckbox)));
    }

    public WebElement radiobutton(String nameRadiobutton) {
        return getRadiobutton().stream().filter(element1 -> element1.getText().equals(nameRadiobutton)).findFirst()
                .orElseThrow(() -> new RuntimeException(format("Radiobutton with name %s not found", nameRadiobutton)));
    }

    public WebElement dropdown(String nameDropdown) {
        return getDropdown().stream().filter(element1 -> element1.getText().equals(nameDropdown)).findFirst()
                .orElseThrow(() -> new RuntimeException(format("Dropdown with name %s not found", nameDropdown)));
    }

    public WebElement log(String nameLog) {
        return getLog().stream().filter(element1 -> element1.getText().contains(nameLog)).findFirst()
                .orElseThrow(() -> new RuntimeException(format("Log: %s not found", nameLog)));

    }

}

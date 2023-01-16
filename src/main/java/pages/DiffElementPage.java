package pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DiffElementPage {

    @FindBy(className = "label-checkbox")
    public List<WebElement> checkbox;

    @FindBy(className = "label-radio")
    public List<WebElement> radiobutton;

    @FindBy(css = ".colors>select > option")
    public List<WebElement> dropdown;

    @FindBy(css = ".panel-body-list.logs")
    public List<WebElement> log;

}

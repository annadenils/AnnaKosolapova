package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderPage {

    @FindBy(className = "dropdown-toggle")
    public WebElement dropdownService;

    public void clickService() {
        dropdownService.click();
    }

    @FindBy(xpath = "//li/a[text()='Different elements']")
    public WebElement diffElements;

    public void clickDiffEl() {
        diffElements.click();
    }

    @FindBy(css = ".dropdown.open > ul")
    public List<WebElement> listOfDropdownService;

    public List<WebElement> getListOfDropdownService() {
        return listOfDropdownService;
    }
}

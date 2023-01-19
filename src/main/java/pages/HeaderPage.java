package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage {

    public WebElement getDropdownService() {
        return dropdownService;
    }

    @FindBy(className = "dropdown-toggle")
    private WebElement dropdownService;

    public void clickService() {
        getDropdownService().click();
    }

    public WebElement getDiffElements() {
        return diffElements;
    }

    @FindBy(xpath = "//li/a[text()='Different elements']")
    private WebElement diffElements;

    public void clickDiffEl() {
        getDiffElements().click();
    }
}

package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

    public HeaderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

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

    @FindBy(xpath = "//li/a[text()='User Table ']")
    private WebElement userTable;

    public void clickUserTable() {
        userTable.click();
    }

    @FindBy(css = ".dropdown.open > ul")
    public List<WebElement> listOfDropdownService;

    public List<WebElement> getListOfDropdownService() {
        return listOfDropdownService;
    }
}

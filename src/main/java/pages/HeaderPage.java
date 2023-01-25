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

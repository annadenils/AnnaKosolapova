package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserTablePage {

    public UserTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tbody//select")
    public List<WebElement> listOfDropdownTypeOnUserTable;

    public List<WebElement> getListOfDropdownTypeOnUserTable() {
        return listOfDropdownTypeOnUserTable;
    }

    @FindBy(xpath = "//tbody//a")
    public List<WebElement> listOfUsersOnUserTable;

    @FindBy(xpath = "//tbody//span")
    public List<WebElement> listOfDescriptionOnUserTable;

    @FindBy(xpath = "//tbody//input")
    public List<WebElement> listOfCheckboxOnUserTable;

    @FindBy(xpath = "//tbody//tr[1]//td//select")
    public List<WebElement> listOfDropDownForRoman;

    @FindBy(xpath = "//tr//td[1]")
    public List<WebElement> numberType;

}

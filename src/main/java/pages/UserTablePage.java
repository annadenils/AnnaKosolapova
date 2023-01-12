package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserTablePage {

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

}

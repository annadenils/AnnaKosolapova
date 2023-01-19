package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage {

    @FindBy(className = "dropdown-toggle")
    public WebElement Service;

    @FindBy(xpath = "//li/a[text()='Different elements']")
    public WebElement diffElements;

    public void clickService() {
        Service.click();
    }

    public void clickDiffEl() {
        diffElements.click();
    }
}

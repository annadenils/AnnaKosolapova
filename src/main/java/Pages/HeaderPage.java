package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage {

    @FindBy(className = "dropdown-toggle")
    public WebElement Service;

    @FindBy(partialLinkText = "DIFFERENT ELEMENTS")
    public WebElement diffElements;

    public void clickService(){
        Service.click();
    }

    public void clickDiffEl(){
        diffElements.click();
    }
}

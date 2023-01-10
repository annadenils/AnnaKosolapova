package hw4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

    @FindBy(className = "dropdown-toggle")
    public WebElement Service;


    public void clickService(){
        Service.click();
    }

    @FindBy(xpath = "//li/a[text()='Different elements']")
    public WebElement diffElements;

    public void clickDiffEl(){
        diffElements.click();
    }

}
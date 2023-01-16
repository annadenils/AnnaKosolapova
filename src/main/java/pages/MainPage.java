package pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    @FindBy(id = "user-icon")
    private WebElement loginIcon;

    @FindBy(id = "name")
    private WebElement login;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(xpath = "//ul[contains(@class,'m-l8')]/li")
    public List<WebElement> headerItems;

    @FindBy(className = "benefit-icon")
    public List<WebElement> iconsItems;

    @FindBy(className = "benefit-txt")
    public List<WebElement> iconsTextItems;

    @FindBy(id = "frame")
    public WebElement frame;

    @FindBy(id = "frame-button")
    public WebElement frameButton;

    @FindBy(css = "ul[class='sidebar-menu left']>li")
    public List<WebElement> leftMenu;

    public void login(String username, String password1) {
        loginIcon.click();
        login.sendKeys(username);
        password.sendKeys(password1);
        loginButton.click();
    }

    public WebElement getUserName() {
        return userName;
    }

}

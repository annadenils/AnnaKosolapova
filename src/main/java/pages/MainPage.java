package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

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
    private List<WebElement> headerItems;

    @FindBy(className = "benefit-icon")
    private List<WebElement> iconsItems;

    @FindBy(className = "benefit-txt")
    private List<WebElement> iconsTextItems;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(css = "ul[class='sidebar-menu left']>li")
    private List<WebElement> leftMenu;

    public void login(String username, String password1) {
        loginIcon.click();
        login.sendKeys(username);
        password.sendKeys(password1);
        loginButton.click();
    }

    public WebElement getUserName() {
        return userName;
    }

    public List<WebElement> getHeaderItems() {
        return headerItems;
    }

    public List<WebElement> getIconsItems() {
        return iconsItems;
    }

    public List<WebElement> getIconsTextItems() {
        return iconsTextItems;
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public List<WebElement> getLeftMenu() {
        return leftMenu;
    }

}

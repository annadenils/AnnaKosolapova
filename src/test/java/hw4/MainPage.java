package hw4;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(css = "ul[class='uui-navigation nav navbar-nav m-l8']>li")
    private List<WebElement> headerItems;

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

    public void login(String username, String password1){
        loginIcon.click();
        login.sendKeys(username);
        password.sendKeys(password1);
        loginButton.click();
    }

    public WebElement getUserName(){
        return userName;
    }

    public List<WebElement> headerName(){
        return headerItems;
    }

    public List<WebElement> iconsItems(){
        return iconsItems;
    }

    public List<WebElement> iconsTextItems(){
        return iconsTextItems;
    }

    public List<WebElement> leftMenuName(){
        return leftMenu;
    }
}

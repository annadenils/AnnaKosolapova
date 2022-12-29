package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
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

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public static LoginPage using(WebDriver driver){
        return new LoginPage(driver);
    }

    public void login(String username, String password1){
        loginIcon.click();
        login.sendKeys(username);
        password.sendKeys(password1);
        loginButton.click();
    }

//    public LoginPage LoginIcon(){
//        this.loginIcon.click();
//        return this;
//    }

    public WebElement getUserName(){
        return userName;
    }
}

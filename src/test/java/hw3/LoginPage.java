package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//    public WebDriver driver;
//    public LoginPage(WebDriver driver){
//        PageFactory.initElements(driver, this);
//        this.driver = driver;
//    }
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


    public void login(String username, String passwrd){
        loginIcon.click();
        login.sendKeys(username);
        password.sendKeys(passwrd);
        loginButton.click();
    }

    public WebElement getUserName(){
        return userName;
    }
}

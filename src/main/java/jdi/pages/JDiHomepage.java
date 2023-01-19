package jdi.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import jdi.forms.LoginForm;
import jdi.objects.User;

public class JDiHomepage extends WebPage {

    @FindBy(id = "user-icon")
    private Icon loginIcon;

    @FindBy(id = "user-name")
    private Label userName;

    public LoginForm loginForm;

    public void login(User user) {
        loginIcon.click();
        loginForm.login(user);
    }

    public String userName() {
        return userName.getText();
    }


}

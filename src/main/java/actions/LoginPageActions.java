package actions;

import locators.LoginPageLocators;
import org.openqa.selenium.support.PageFactory;
import utils.HelperClass;

public class LoginPageActions {
    LoginPageLocators loginPageLocators ;
            //=null;

    public LoginPageActions() {

        this.loginPageLocators = new LoginPageLocators();

        PageFactory.initElements(HelperClass.getDriver(), loginPageLocators);
    }

    // Get the Error Message
    public String getErrorMessage() {
        return loginPageLocators.errorMessage.getText();
    }

    public void login(String email, String password) {

        // Fill email
        loginPageLocators.emailBox.sendKeys(email);

        // Fill password
        loginPageLocators.passwordBox.sendKeys(password);

        // Click Login button
        loginPageLocators.loginButton.click();
    }
}

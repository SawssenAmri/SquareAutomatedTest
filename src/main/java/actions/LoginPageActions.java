package actions;

import io.cucumber.datatable.DataTable;
import locators.LoginPL;
import org.openqa.selenium.support.PageFactory;
import utils.HelperClass;

public class LoginPageActions {
    LoginPL loginPageLocators ;
            //=null;

    public LoginPageActions() {

        this.loginPageLocators = new LoginPL();

        PageFactory.initElements(HelperClass.getChromeDriver(), loginPageLocators);
    }

    // Get the Error Message
    public String getErrorMessage() {
        return loginPageLocators.errorMessage.getText();
    }

    public void login(DataTable dataValue) {

        // Fill email
        loginPageLocators.emailBox.sendKeys(dataValue.cell(0,0));

        // Fill password
        loginPageLocators.passwordBox.sendKeys(dataValue.cell(0,1));

        // Click Login button
        loginPageLocators.loginButton.click();
    }
    public void loginWithString(String email, String password) {

        // Fill email
        loginPageLocators.emailBox.sendKeys(email);

        // Fill password
        loginPageLocators.passwordBox.sendKeys(password);

        // Click Login button
        loginPageLocators.loginButton.click();
    }
}

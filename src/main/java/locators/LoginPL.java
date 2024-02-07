package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPL {

    @FindBy(id = "sign-in-email-input")
    public WebElement emailBox;
    @FindBy(id = "sign-in-password-input")
    public WebElement passwordBox;

    @FindBy(id = "sign-in-button")
    public WebElement loginButton;

    @FindBy(id = "error-alert")
    public WebElement errorMessage;
}

package definitions;

import actions.HomePageActions;
import actions.LoginPageActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.testng.Assert;
import utils.HelperClass;

public class LoginPageDefinition {
    LoginPageActions objLogin = new LoginPageActions();
    HomePageActions objHomePage = new HomePageActions();

    @Given("User is on SquareLogin page {string}")
    public void loginTest(String url) {

        HelperClass.openPage(url);

    }

    @When("User enters email and password")
    public void goToHomePage(DataTable dtValue) {

        // login to application
        objLogin.login(dtValue);
    }

    @Then("User should be able to login successfully and new page open")
    public void verifyLogin() {

        // Verify home page
        Assert.assertTrue(objHomePage.getDashboardText().contains("Tableaux de bord"));

    }

    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {

        // Verify error message
        Assert.assertEquals(objLogin.getErrorMessage(), expectedErrorMessage);

    }

    @When("User enters email as {string} and password as {string}")
    public void userEntersEmailAsAndPasswordAs(String email, String password) {
        objLogin.loginWithString(email, password);
    }
}

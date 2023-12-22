package definitions;

import actions.CompaniesPageActions;
import actions.HomePageActions;
import io.cucumber.java.en.*;
import org.testng.Assert;
import utils.HelperClass;

public class AddCompanyDefinition {
    HomePageActions objHomePage = new HomePageActions();
    CompaniesPageActions objCompaniesPage = new CompaniesPageActions();


    @And("user clicks on Enterprise within the menu")
    public void clicksEnterprise() {
        objHomePage.getCompaniesInterface(HelperClass.getChromeDriver());
        Assert.assertTrue(objCompaniesPage.getCompaniesListText().contains("Liste des entreprises"));
    }

    @And("user clicks on Add Enterprise")
    public void userClicksOnAddEnterprise() {
        objCompaniesPage.clickOnAddCompany();
    }

    @When("user enter {string} into {string}")
    public void userEnterInto(String value, String field) throws InterruptedException {
        objCompaniesPage.fillRequiredField(value, field);
        Thread.sleep(3000);
    }

    @Then("the {string} validation should be {string}")
    public void theValidationShouldBe(String field, String errorMessage) {
        Assert.assertEquals(objCompaniesPage.getErrorMessage(field), errorMessage);
    }
}

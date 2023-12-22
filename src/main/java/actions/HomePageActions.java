package actions;

import locators.HomePL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utils.HelperClass;

public class HomePageActions {
    HomePL homePageLocators;
    FluentWait<WebDriver> fluentWait = HelperClass.initializeFluentWait(HelperClass.getChromeDriver());

    public HomePageActions() {
        this.homePageLocators = new HomePL();
        PageFactory.initElements(HelperClass.getChromeDriver(), homePageLocators);
    }

    public String getDashboardText() {
        return homePageLocators.dashboardText.getText();
    }

    public void getCompaniesInterface(WebDriver driver) {
        fluentWait.until(ExpectedConditions.visibilityOf(homePageLocators.CompanyButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homePageLocators.CompanyButton);
    }
}

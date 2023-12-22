package actions;

import locators.CompaniesPL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utils.HelperClass;

public class CompaniesPageActions {
    CompaniesPL companiesPL;
    FluentWait<WebDriver> fluentWait = HelperClass.initializeFluentWait(HelperClass.getChromeDriver());

    public CompaniesPageActions() {
        this.companiesPL = new CompaniesPL();
        PageFactory.initElements(HelperClass.getChromeDriver(), companiesPL);
    }

    public String getCompaniesListText() {
        fluentWait.until(ExpectedConditions.visibilityOf(companiesPL.list_Of_Companies_Text));
        return companiesPL.list_Of_Companies_Text.getText();
    }

    public void clickOnAddCompany() {
        fluentWait.until(ExpectedConditions.visibilityOf(companiesPL.add_Company_Button));
        companiesPL.add_Company_Button.click();
    }

    public void fillRequiredField(String value, String field) {

        switch (field) {
            case "company_name" -> {
                //companiesPL.company_name.click();
                companiesPL.company_name.sendKeys(value);
                companiesPL.company_name.sendKeys(Keys.TAB);

            }
            case "company_serial_number" -> {
                companiesPL.company_serial_number.sendKeys(value);
                companiesPL.company_serial_number.sendKeys(Keys.TAB);

            }
            case "company_email" -> {
                companiesPL.company_email.sendKeys(value);
                companiesPL.company_email.sendKeys(Keys.TAB);

            }
            case "company_phone" -> {
                companiesPL.company_name.sendKeys("aa");
                companiesPL.company_serial_number.sendKeys("12345678");
                companiesPL.company_email.sendKeys("testAuto1@gmail.com");
                companiesPL.company_address.sendKeys("12 Avenue Cornich");
                companiesPL.postcode.sendKeys("1234");
                companiesPL.company_phone.sendKeys(value);
                ((JavascriptExecutor) HelperClass.getChromeDriver()).executeScript("arguments[0].click();", companiesPL.next_btn);

            }
            case "company_country" -> {
                companiesPL.company_name.sendKeys("aa");
                companiesPL.company_serial_number.sendKeys("12345678");
                companiesPL.company_email.sendKeys("testAuto1@gmail.com");
                companiesPL.company_address.sendKeys("12 Avenue Cornich");
                companiesPL.postcode.sendKeys("1234");
                companiesPL.company_phone.sendKeys("12345678");
                companiesPL.company_country.sendKeys(value);
                companiesPL.company_country.sendKeys(Keys.ENTER);
                companiesPL.next_btn.click();

            }
            case "company_city" -> {
                companiesPL.company_name.sendKeys("aa");
                companiesPL.company_serial_number.sendKeys("12345678");
                companiesPL.company_email.sendKeys("testAuto1@gmail.com");
                companiesPL.company_address.sendKeys("12 Avenue Cornich");
                companiesPL.postcode.sendKeys("1234");
                companiesPL.company_phone.sendKeys("12345678");
                companiesPL.company_country.sendKeys("Tunisia");
                companiesPL.company_country.sendKeys(Keys.ENTER);
                companiesPL.company_city.sendKeys(value);
                companiesPL.company_city.sendKeys(Keys.ENTER);
                companiesPL.next_btn.click();

            }
            case "company_address" -> companiesPL.company_address.sendKeys(value);

            case "postcode" -> companiesPL.postcode.sendKeys(value);
        }
    }

    public String getErrorMessage(String field) {

        return switch (field) {
            case "company_name" -> companiesPL.error_company_name.getText();
            case "company_serial_number" -> companiesPL.error_company_serial_num.getText();
            case "company_email" -> companiesPL.error_company_email.getText();
            case "company_phone" -> companiesPL.error_company_phone.getText();
            case "company_country_empty" -> companiesPL.error_company_country.getText();
            case "company_country_invalid", "company_city_invalid" -> companiesPL.no_option.getText();
            case "company_city_empty" -> companiesPL.error_company_city.getText();
            default -> "";
        };
    }
}

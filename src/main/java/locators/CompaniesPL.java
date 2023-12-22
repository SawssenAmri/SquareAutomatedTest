package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompaniesPL {
    @FindBy(xpath = "//*[@id=\"root\"]//h5")
    public WebElement list_Of_Companies_Text;
    @FindBy(id = "add-enterprise")
    public WebElement add_Company_Button;

    @FindBy(id = "name-enterprise")
    public WebElement company_name;
    @FindBy(xpath = "//*[@id=\"enterprise\"]//div[3]/div[1]/div[1]//div[3]/div")
    public WebElement error_company_name;

    @FindBy(id = "serial-number-enterprise")
    public WebElement company_serial_number;
    @FindBy(xpath = "//*[@id=\"enterprise\"]//div[3]/div[1]/div[2]/div/div[3]/div")
    public WebElement error_company_serial_num;
    @FindBy(id = "email-enterprise")
    public WebElement company_email;
    @FindBy(xpath = "//*[@id=\"enterprise\"]//div[1]/div[3]/div[2]/div[1]//div[3]/div")
    public WebElement error_company_email;
    @FindBy(id = "phone-enterprise")
    public WebElement company_phone;
    @FindBy(xpath = "//*[@id=\"enterprise\"]//div[1]/div[3]/div[3]/div[1]/div[2]/div")
    public WebElement error_company_phone;
    @FindBy(id = "enterprise-country")
    public WebElement company_country;
    @FindBy(xpath = "//div[text()=\"Pays est obligatoire\"]")
    public WebElement error_company_country;
    @FindBy(xpath = "//div[text()=\"Pas d'options\"]")
    public WebElement no_option;
    @FindBy(id = "enterprise-city")
    public WebElement company_city;
    @FindBy(xpath = "//div[text()=\"Ville est obligatoire\"]")
    public WebElement error_company_city;

    @FindBy(id = "physiqual-address-enterprise")
    public WebElement company_address;
    @FindBy(xpath = "//*[@id=\"enterprise\"]//div[1]/div[3]/div[5]/div[1]//div[3]/div")
    public WebElement error_address;
    @FindBy(id = "post-code-enterprise")
    public WebElement postcode;
    @FindBy(xpath = "//*[@id=\"enterprise\"]//div[1]/div[3]/div[5]/div[2]//div[3]/div")
    public WebElement error_postcode;

    @FindBy(id = "send")
    public WebElement next_btn;


}

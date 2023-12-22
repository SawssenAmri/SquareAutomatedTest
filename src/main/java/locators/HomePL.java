package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePL {

    @FindBy (xpath = "//*[@id=\"root\"]/div[1]/div/ul/a[1]/li/div/div[2]/span")
    public WebElement dashboardText;
    @FindBy(xpath = "//span[text()=' Entreprises']")
    public WebElement CompanyButton;

}

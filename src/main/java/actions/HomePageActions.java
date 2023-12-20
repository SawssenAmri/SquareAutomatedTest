package actions;

import locators.HomePageLocators;
import org.openqa.selenium.support.PageFactory;
import utils.HelperClass;

public class HomePageActions {
    HomePageLocators homePageLocators ;
            //= null;

    public HomePageActions(){
        this.homePageLocators=new HomePageLocators();
        PageFactory.initElements(HelperClass.getDriver(),homePageLocators);
    }

    public String getDashboardText(){
        return homePageLocators.dashboardText.getText();
    }
}

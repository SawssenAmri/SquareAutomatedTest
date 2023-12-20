import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class AllTestCases  {
    @Test
    public void userClickOnMenuEnterprise() throws InterruptedException {
        //Login to square
       WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://192.168.1.192:3000/");
       driver.findElement(By.id("sign-in-email-input")).sendKeys("hamza.ramy.ing@gmail.com");
       driver.findElement(By.id("sign-in-password-input")).sendKeys("Aziz@123");
       driver.findElement(By.id("sign-in-button")).click();

        //access to Enterprise interface
        WebElement entreprise = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/ul/a[2]/li/div/div[2]/span"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", entreprise);
        driver.findElement(By.id("add-enterprise")).click();

        //First step
        driver.findElement(By.id("name-enterprise")).sendKeys("Enterprise " + new Random().nextInt(100));
        driver.findElement(By.id("serial-number-enterprise")).sendKeys("ETRPS" + new Random().nextInt(100000));
        driver.findElement(By.id("email-enterprise")).sendKeys(new Random().nextInt(10000) + "a@aa.aaa");
        driver.findElement(By.xpath("//input[@class='form-control ']")).sendKeys("5" + new Random().nextInt(10000000));

        WebElement country = driver.findElement(By.id("enterprise-country"));
        WebElement city = driver.findElement(By.id("enterprise-city"));

        country.sendKeys("Tunisia");
        country.sendKeys(Keys.ENTER);
        city.sendKeys("Beja");
        city.sendKeys(Keys.ENTER);

        driver.findElement(By.id("physiqual-address-enterprise")).sendKeys("18 aaa'A aaa aaaaaaa");
        driver.findElement(By.id("post-code-enterprise")).sendKeys("0000");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"send\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
        Thread.sleep(3000);

        //Second step
        driver.findElement(By.name("facilityName")).sendKeys("Establishment" + new Random().nextInt(100));
        driver.findElement(By.id("facility-serial-number")).sendKeys("ETBLMS" + new Random().nextInt(1000));
        WebElement establishmentType = driver.findElement(By.id("size-small-standard-0"));
        establishmentType.sendKeys("crèche");
        establishmentType.sendKeys(Keys.ARROW_DOWN);
        establishmentType.sendKeys(Keys.ENTER);
        WebElement sendBtn = driver.findElement(By.id("send"));
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendBtn);

        //Third Step
        driver.findElement(By.id("company-admin-first-name")).sendKeys("ghaith");
        driver.findElement(By.id("company-admin-last-name")).sendKeys("bou rawi");
        driver.findElement(By.id("company-admin-email")).sendKeys("companyAD" + new Random().nextInt(100) + "@gmail.com");
        driver.findElement(By.name("CompanyAdmingender")).click();
        driver.findElement(By.xpath("//*[@id=\"enterprise\"]//div[4]/div[1]/div[1]/input")).sendKeys("2" + new Random().nextInt(10000000));
        WebElement submit = driver.findElement(By.id("send"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[5]/div"))));
        WebElement popupSuccess = driver.findElement(By.xpath("//h2[text()='succés !']"));
        Assert.assertTrue(popupSuccess.isDisplayed(), "the popup is not displayed");
        driver.findElement(By.xpath("/html//div[6]/button[1]")).click();
        WebElement elementPerPage =  driver.findElement(By.xpath("/html//div[2]/input"));
        elementPerPage.sendKeys("25");
        elementPerPage.sendKeys(Keys.ARROW_DOWN);
        elementPerPage.sendKeys(Keys.ENTER);
        int companyNumber = driver.findElements(By.id("delete-enterprise")).size();
        driver.findElements(By.id("delete-enterprise")).get(companyNumber-1).click();
        driver.findElement(By.xpath("/html/body/div[5]/div/div[6]/button[1]")).click();

    }
}

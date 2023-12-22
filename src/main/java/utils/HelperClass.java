package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class HelperClass {
    private static HelperClass helperClass;
    private static WebDriver driver;
    public final static int TIMEOUT = 15;

    private HelperClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
    }

    public static void openPage(String url) {
        driver.get(url);
    }
    public static WebDriver getChromeDriver() {
        return driver;
    }

    public static void setUpDriver() {

        if (helperClass == null) {

            helperClass = new HelperClass();
        }
    }


    public static void tearDown() {

        if (driver != null) {
            driver.close();
            driver.quit();
        }

        helperClass = null;
    }

    public static FluentWait<WebDriver> initializeFluentWait(WebDriver driver) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) // Maximum time to wait
                .pollingEvery(Duration.ofSeconds(5)); // Check for the condition every 5 seconds
    }


}

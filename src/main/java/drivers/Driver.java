package drivers;

import org.openqa.selenium.WebDriver;

public class Driver {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String option = (System.getProperty("BROWSER") == null) ? "chrome" : System.getProperty("BROWSER");
            driver = Browsers.getBrowser(option);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

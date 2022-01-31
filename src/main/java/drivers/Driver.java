package drivers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Driver {
    public static WebDriver driver;
    public static Browser browser;

    public static WebDriver getDriver() {
        if (driver == null) {
            String option = (System.getProperty("BROWSER") == null) ? "chrome" : System.getProperty("BROWSER");

            if (option.equals("firefox")) {
                driver = Browsers.getBrowser(Browser.FIREFOX);
                browser = Browser.FIREFOX;
            }
            else {
                driver = Browsers.getBrowser(Browser.CHROME);
                browser = Browser.FIREFOX;
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void back() {
        if (driver != null) {
            if (browser == Browser.CHROME) {
                driver.navigate().back();
            }else {
                ((JavascriptExecutor)driver).executeScript("window.history.go(-1)");
                ((JavascriptExecutor)driver).executeScript("window.history.go(-1)");
            }
        }

    }
}

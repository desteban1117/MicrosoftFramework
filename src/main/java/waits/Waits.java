package waits;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private static final int TIME = 10;
//Duration.ofSeconds(TIME, 0)
    public static WebElement visibilityOf(WebElement element) {
        return new WebDriverWait(Driver.getDriver(), TIME).until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement visibilityOf(WebElement element, int time) {
        return new WebDriverWait(Driver.getDriver(), TIME).until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement visibilityOfElementLocated(By locator) {
        return new WebDriverWait(Driver.getDriver(), TIME).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement elementToBeClickable(WebElement element) {
        return new WebDriverWait(Driver.getDriver(), TIME).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement elementToBeClickable(WebElement element, int time) {
        return new WebDriverWait(Driver.getDriver(), TIME).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement elementToBeClickable(By locator) {
        return new WebDriverWait(Driver.getDriver(), TIME).until(ExpectedConditions.elementToBeClickable(locator));
    }
}

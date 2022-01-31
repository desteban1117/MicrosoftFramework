package waits;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class Waits {
    private static final long TIME = 10L;
//Duration.ofSeconds(TIME, 0)
    public static WebElement visibilityOf(WebElement element) {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(TIME)).until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement visibilityOf(WebElement element, long time) {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement visibilityOfElementLocated(By locator) {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(TIME)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement elementToBeClickable(WebElement element) {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(TIME)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement elementToBeClickable(WebElement element, long time) {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement elementToBeClickable(By locator) {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(TIME)).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitUntilElementListSizeGreaterThan(List<WebElement> elements, int size) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(TIME))
                .pollingEvery(Duration.ofSeconds(1L))
                .ignoring(NoSuchElementException.class);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (elements.size() > size);
            }});
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

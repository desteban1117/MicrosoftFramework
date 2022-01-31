package pagesObjects;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static waits.Waits.*;

public class BasePage {

    private WebDriver driver;

    public BasePage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    protected String getText(WebElement element) {
        return visibilityOf(element).getText();
    }

    protected void sendKeys(String value, WebElement element) {
        visibilityOf(element).clear();
        element.sendKeys(value);
    }

    protected void sendKeys(String value, WebElement element, int time) {
        visibilityOf(element, time).clear();
        element.sendKeys(value);
    }

    protected void click(WebElement element) {
        elementToBeClickable(element);
        element.click();
    }

    protected void click(WebElement element, int time) {
        elementToBeClickable(element, time).click();
    }

    protected void click(By locator) {
        elementToBeClickable(locator).click();
    }

    protected boolean isDisplayed(WebElement element, int time) {
        try {
            return visibilityOf(element, time).isDisplayed();
        }
        catch (Exception e) {
            return false;
        }
    }

    protected boolean isDisplayed(By locator) {
        try {
            return visibilityOfElementLocated(locator).isDisplayed();
        }
        catch (Exception e) {
            return false;
        }
    }

    protected void scrollUntilElement(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", visibilityOfElementLocated(locator));
    }

    protected void scrollUntilElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}

package pagesObjects.resultPages;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.locators.RelativeLocator;
import pagesObjects.BasePage;
import waits.Waits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultSearchPage extends BasePage {

    @FindBy(linkText = "Comprar")
    WebElement shopLink;

    @FindAll(@FindBy(className = "m-channel-placement-item"))
    List<WebElement> items;

    @FindBy(xpath = "//span[.='Siguiente']")
    WebElement nexButton;

    public void clickShopLink() {
        click(shopLink);
    }

    public void clickFirstItem() {
        click(items.get(0));
    }

    public void clickSecondItem() {
        click(items.get(1));
    }

    public boolean isResultDisplayed(String value) {
        return isDisplayed(By.xpath("//*[.='" + value + "']"));
    }

    public void clickShowAllOf(String value) {
        scrollUntilElement(By.xpath("//*[.='" + value + "']"));
        click(RelativeLocator.with(By.cssSelector(".c-hyperlink.f-show-all")).toRightOf(By.xpath("//*[.='" + value + "']")));
    }

    public int getItemsNumber() {
        int number = 0;

        while (isDisplayed(nexButton, 3)) {
            number += items.size();
            scrollUntilElement(nexButton);
            click(nexButton);
        }
        number += items.size();
        return number;
    }
}

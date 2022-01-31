package pagesObjects.menus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagesObjects.BasePage;
import pagesObjects.resultPages.ResultSearchPage;

public class BaseMenu extends BasePage {

    @FindBy(id = "search")
    WebElement searchButton;

    @FindBy(id = "cli_shellHeaderSearchInput")
    WebElement searchTextBox;

    @FindBy(className = "shopping-cart-amount")
    WebElement shoppingCartAmount;

    public ResultSearchPage search(String value) {
        click(searchButton);
        sendKeys(value, searchTextBox);
        click(searchButton);
        return new ResultSearchPage();
    }

    public int getShoppingCartAmount() {
        return Integer.parseInt(getText(shoppingCartAmount));
    }

}

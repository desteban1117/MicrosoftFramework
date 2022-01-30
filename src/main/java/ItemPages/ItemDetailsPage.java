package ItemPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagesObjects.BasePage;
import pagesObjects.menus.BaseMenu;

public class ItemDetailsPage extends BasePage {

    @FindBy(xpath = "//*[contains(@title,'Agregar')]")
    WebElement addCartButton;

    public void AddItemToCart() {
        click(addCartButton);
    }

    public int getShoppingCartAmount() {
        return new BaseMenu().getShoppingCartAmount();
    }
}

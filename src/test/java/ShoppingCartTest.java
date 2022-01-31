import ItemPages.ItemDetailsPage;
import drivers.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesObjects.MicrosoftRedirectionMessage;
import pagesObjects.menus.HomeMenu;
import pagesObjects.resultPages.ResultSearchPage;

public class ShoppingCartTest extends BaseTest{
    @Test
    public void shoppingCartTest() {
        HomeMenu homeMenu = new HomeMenu();
        ResultSearchPage resultSearchPage = homeMenu.search("Halo");
        MicrosoftRedirectionMessage message = new MicrosoftRedirectionMessage();
        message.stayInStoreIfMessageAppear();
        ItemDetailsPage itemDetailsPage = resultSearchPage.clickShopLink()
                .clickItem(1);
        itemDetailsPage.AddItemToCart();
        Assert.assertEquals(1, itemDetailsPage.getShoppingCartAmount());
        Driver.getDriver().navigate().back();
        resultSearchPage.clickItem(2);
        itemDetailsPage.AddItemToCart();
        Assert.assertEquals(2, itemDetailsPage.getShoppingCartAmount());

    }
}

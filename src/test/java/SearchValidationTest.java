import ItemPages.ItemDetailsPage;
import drivers.Driver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagesObjects.MicrosoftRedirectionMessage;
import pagesObjects.menus.HomeMenu;
import pagesObjects.resultPages.ResultSearchPage;
import pojos.Search;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class SearchValidationTest extends BaseTest{

    @Test(dataProvider = "data")
    public void searchValidationTest(Search search) {
        HomeMenu homeMenu = new HomeMenu();
        homeMenu.search(search.getSearch());
        ResultSearchPage resultSearchPage = new ResultSearchPage();
        MicrosoftRedirectionMessage message = new MicrosoftRedirectionMessage();
        message.stayInStoreIfMessageAppear();
        resultSearchPage.clickShopLink();
        assertTrue(resultSearchPage.isResultDisplayed(search.getResult()));
        resultSearchPage.clickShowAllOf(search.getResult());
        Assert.assertEquals(resultSearchPage.getItemsNumber(), search.getResultNumber());
    }

    @Test
    public void shoppingCartTest() {
        HomeMenu homeMenu = new HomeMenu();
        homeMenu.search("Halo");
        ResultSearchPage resultSearchPage = new ResultSearchPage();
        MicrosoftRedirectionMessage message = new MicrosoftRedirectionMessage();
        message.stayInStoreIfMessageAppear();
        resultSearchPage.clickShopLink();
        resultSearchPage.clickFirstItem();
        ItemDetailsPage itemDetailsPage = new ItemDetailsPage();
        itemDetailsPage.AddItemToCart();
        Assert.assertEquals(1, itemDetailsPage.getShoppingCartAmount());
        Driver.getDriver().navigate().back();
        resultSearchPage.clickSecondItem();
        itemDetailsPage.AddItemToCart();
        Assert.assertEquals(2, itemDetailsPage.getShoppingCartAmount());

    }

    @DataProvider(name = "data")
    public Object[][] getData() throws IOException, ParseException {
        Object content = new JSONParser().parse(new FileReader("src/main/resources/data.json"));
        List<Search> list = Arrays.stream(((JSONArray)content).toArray()).map(this::parseJsonToSearch).collect(Collectors.toList());

        Object[][] data = new Object[list.size()][1];

        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i);
        }

        return data;
    }

    public Search parseJsonToSearch(Object search1) {
        JSONObject search = (JSONObject)search1;
        Search search2 = new Search((String) search.get("search"), (String) search.get("result"), ((Long) search.get("resultNumber")).intValue());
        return search2;
    }

}

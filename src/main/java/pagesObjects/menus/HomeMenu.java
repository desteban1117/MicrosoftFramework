package pagesObjects.menus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeMenu extends BaseMenu {

    @FindBy(id = "shellmenu_2")
    WebElement windowsButton;

    public void clickWindows() {
        click(windowsButton);
    }

}

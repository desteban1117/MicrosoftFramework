package pagesObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MicrosoftRedirectionMessage extends BasePage{

    @FindBy(id = "R1MarketRedirect-close")
    WebElement stayButton;

    public void stayInStoreIfMessageAppear() {
        if(isDisplayed(stayButton, 2)) {
            click(stayButton);
        }
    }
}

import drivers.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void beforeTest() {
        Driver.getDriver().get("https://www.microsoft.com/es-mx/");
    }

    @AfterTest
    public void afterTest() {
        Driver.quitDriver();
    }
}

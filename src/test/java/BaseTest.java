import drivers.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    @BeforeTest
    public void beforeTest() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10, 0));
        Driver.getDriver().get("https://www.microsoft.com/es-mx/");
    }

    @AfterTest
    public void afterTest() {
        Driver.quitDriver();
    }
}

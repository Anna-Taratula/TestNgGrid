import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {
    WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeTest(String browser) throws MalformedURLException {


        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName(browser);

        driver = new RemoteWebDriver(new URL("http://localhost:4444/"), dc);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("https://volia.com/");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}

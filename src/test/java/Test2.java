import model.AuthorizationPage;
import model.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Test2 extends BaseTest {
    private static final String INPUT_NUMBER = "+380978683495";


    @Test
    public void test2() {
        AuthorizationPage authorizationPage = new MainPage(driver).navigateTo().goToAuthorization();

        authorizationPage.fillPhoneNumber(INPUT_NUMBER);

        authorizationPage.clickSignInToPersonalAccount();


        WebElement webElement = (new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS))).until(ExpectedConditions
                .presenceOfElementLocated(By.id("phoneFormNotFoundError")));
        Assert.assertTrue(webElement.isDisplayed());


    }


}

import model.InternetPage;
import model.MainPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1 extends BaseTest {
    @Test
    public void test1() {

        InternetPage internetPage = new MainPage(driver).goToInternetPage().clickConnectInternetPackage();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='shopForm.component__title']")).isDisplayed());


    }
}

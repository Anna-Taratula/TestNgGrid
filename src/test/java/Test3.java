import model.MainPage;
import model.SearchPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test3 extends BaseTest {
    @Test
    public void test3() {
        final String INPUT_VALUE = "Інтерактивне ТБ";


        SearchPage searchPage = new MainPage(driver).goToSearchPage();

        Assert.assertEquals(INPUT_VALUE, driver.findElement(By.xpath("//div[@class='searchingPage.component__resultContainer']//div[1]//h4[1]//a[1]")).getText());
    }
}

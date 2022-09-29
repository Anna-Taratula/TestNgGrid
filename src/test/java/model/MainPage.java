package model;

import org.openqa.selenium.*;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class MainPage extends BaseModel {


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public AuthorizationPage goToAuthorization() {
        WebElement authorizationIcon = getDriver().findElement(By.xpath("//a[@class='header.component__myCab']"));
        authorizationIcon.click();
        return new AuthorizationPage(getDriver());
    }

    public InternetPage goToInternetPage() {
        WebElement internet = getDriver().findElement(By.xpath("//div[@class='menuButton.component__menuItem']//a[@href='/ukr/internet/']"));
        internet.click();
        return new InternetPage(getDriver());
    }

    public SearchPage goToSearchPage() {

        new WebDriverWait(driver, Duration.of(30, ChronoUnit.SECONDS)).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

        WebElement goToSearch = getDriver().findElement(By.xpath("//div[@class='header.component__bottomHeader']/button[1]//*[name()='svg']"));
        goToSearch.click();

        WebElement input = (new WebDriverWait(getDriver(), Duration.of(20, ChronoUnit.SECONDS))).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='searchBar.component__inputContainer']//input[@type='text']")));

        input.sendKeys("Інтерактивне ТБ");
        input.sendKeys(Keys.ENTER);
        WebElement searchValue = (new WebDriverWait(driver, Duration.of(20, ChronoUnit.SECONDS))).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='searchingPage.component__resultContainer']//div[1]//h4[1]//a[1]")));


        return new SearchPage(getDriver());
    }

}

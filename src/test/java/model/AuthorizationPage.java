package model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class AuthorizationPage extends BaseModel {

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public void fillPhoneNumber(String number) {

        WebElement fieldPhoneNumber = getDriver().findElement(By.xpath("//input[@class='signInPage__input'][@name='phone']"));

        new WebDriverWait(driver, Duration.of(20, ChronoUnit.SECONDS)).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        fieldPhoneNumber.sendKeys(number);

    }


    public AuthorizationPage clickSignInToPersonalAccount() {

        WebElement webElement = (new WebDriverWait(getDriver(), Duration.of(10, ChronoUnit.SECONDS))).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//button[@id='sendOtpTokenButton']")));
        webElement.click();

        return this;
    }
}

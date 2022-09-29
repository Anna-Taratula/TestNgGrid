package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InternetPage extends BaseModel {
    public InternetPage(WebDriver driver) {
        super(driver);
    }

    public InternetPage clickConnectInternetPackage() {
        WebElement clickConnectInternetPackage = getDriver().findElement(By.xpath("//div[@class='banner.component__body banner.component__left']//button[@class='button.component__simpleButton'][contains(text(),'Підключити')]"));
        clickConnectInternetPackage.click();
        return new InternetPage(getDriver());
    }
}

package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class BaseModel {
    WebDriver driver;

    public BaseModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return driver;
    }


    public MainPage navigateTo() {
        driver.get("https://volia.com/");
        return new MainPage(getDriver());
    }

}

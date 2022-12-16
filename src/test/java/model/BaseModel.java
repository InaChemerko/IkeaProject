package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseModel {
    private final WebDriver driver;
//don't know if we need this page
    protected WebDriver getDriver() {
        return driver;
    }

    public BaseModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }
}

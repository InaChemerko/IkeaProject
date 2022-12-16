package model;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    //public BasePage(WebDriver driver) {
//        super(driver);
//    }

    private final WebDriver driver;

    protected WebDriver getDriver() {
        return driver;
    }



    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }



}

package model;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static runner.TestUtils.getAction;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement cookieOkButton;

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(className = "plp-catalog-product-list")
    private WebElement searchResultList;

    @FindBy(xpath = "//span[@class = 'hnf-header__cart-counter']")
    private WebElement counterInCart;

    @FindBy(xpath = "//div/ul/li[5]/a/span")
    private WebElement shoppingCartButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickCookieOkButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(cookieOkButton)).click();

        return this;
    }

    public HomePage enterWordAndPressEnterInSearchField(String str) {
        getWait().until(ExpectedConditions.elementToBeClickable(searchField)).sendKeys(str + Keys.ENTER);
        getWait().until(ExpectedConditions.visibilityOf(searchResultList));

        return this;
    }

    public HomePage clickAddToCartButton(int num) {
        getAction(getDriver()).moveToElement(getDriver()
                        .findElement(By.xpath("//div[@class='plp-fragment-wrapper'][" + num + "]//div[@class='pip-product-compact']//button[1]")))
                .click().build().perform();

        getWait().until(ExpectedConditions.visibilityOf(counterInCart));

        return this;
    }

    public HomePage scrollToTopPage() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, -document.body.scrollHeight);");

        return this;
    }

    public HomePage clearSearchField() {
        searchField.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);

        return this;
    }

    public ShoppingCartPage clickShoppingCartButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(shoppingCartButton)).click();

        return new ShoppingCartPage(getDriver());
    }
}

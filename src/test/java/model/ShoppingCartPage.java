package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'productList')]")
    private WebElement productList;

    @FindBy(xpath = "//div[contains(@class,'product_contents')]")
    private List<WebElement> productItem;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage loadProductList() {
        getWait().until(ExpectedConditions.visibilityOf(productList));
        return this;
    }

    public List<String> getProductItems() {
        return productItem.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}

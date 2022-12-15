import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class SearchTest extends BaseTest {


    @Test
    public void testSearch() {
        //click ok button for accept cookies
        getDriver().findElement(By.id("onetrust-accept-btn-handler")).click();

        //page load and enter "sofa" in search field
        getWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.name("q"))))
                .sendKeys("sofa" + Keys.ENTER);

        //wait till result will be loaded
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.className("plp-catalog-product-list")));
        //find first item of result and add to cart
        Actions action = new Actions(getDriver());
        action.moveToElement(getDriver()
                        .findElement(By.xpath("//div[@class='plp-fragment-wrapper'][1]//div[@class='pip-product-compact']//button[1]")))
                .click().build().perform();

        //scroll to the top of page
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        //wait till "1" in cart is visible
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'hnf-header__cart-counter']")));
        //enter "table" in search field
        WebElement search = getDriver().findElement(By.name("q"));
        search.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        search.sendKeys("table" + Keys.ENTER);

        //wait till result will be loaded
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.className("plp-catalog-product-list")));
        //find 3 item and add to cart
        action.moveToElement(getDriver()
                        .findElement(By.xpath("//div[@class='plp-fragment-wrapper'][3]//div[@class='pip-product-compact']//button[1]")))
                .click().build().perform();

        //scroll to the top of page
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        //go to sopping cart page
        WebElement shoppingCart = getDriver().findElement(By.xpath("//div/ul/li[5]/a/span"));
        getWait().until(ExpectedConditions.elementToBeClickable(shoppingCart));
        shoppingCart.click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'productList')]")));

        //check if 2 added item is displayed
        Assert.assertEquals(getDriver().findElements(By.xpath("//div[contains(@class,'product_contents')]")).size(), 2);

        //click on discount link, enter random #
        getDriver().findElement(By.xpath("//button[contains(@class,'item-header')]")).click();
        action.moveToElement(getDriver()
                        .findElement(By.id("discountCode"))).click()
                .sendKeys(RandomStringUtils.randomAlphanumeric(15)).perform();
        //move to blue checkout button which is lower since "Bear" overlapped
        action.moveToElement(getDriver().findElement(By.xpath("//button[@data-testid='checkoutButton__default']"))).perform();
        //click apply and check Discount code is invalid
        getDriver().findElement(By.xpath("//span[text()='Apply']")).click();

        Assert.assertTrue(getDriver().findElement(By.xpath("//span[text()='Discount code is invalid.']")).isDisplayed());
    }
}

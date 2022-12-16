package runner;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestUtils {

//    public static void scrollToElement(WebDriver driver, WebElement element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//    }

       public static Actions getAction(WebDriver myDriver){
        return new Actions(myDriver);
    }

//    public static void scrollToTopOfPage(WebDriver myDriver){
//        ((JavascriptExecutor) myDriver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
//    }
}

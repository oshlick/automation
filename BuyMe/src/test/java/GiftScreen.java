import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GiftScreen {

    public static void assertURL(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains("buyme.co.il/search"));
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertTrue(url.contains("buyme.co.il/search"));
    }

    public static void pickGift(WebDriver driver) {
            driver.findElements(By.className(Constants.PATH_TO_GIFT)).get(4).click();
    }
}


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HomeScreen {


        public static void pickPrice(WebDriver driver) {
            driver.findElement(By.xpath(Constants.PATH_TO_SELECT_PRICE)).click();
            driver.findElements(By.className(Constants.PATH_TO_SELECTION)).get(1).click();
        }

        public static void pickArea (WebDriver driver) {
            driver.findElement(By.xpath(Constants.PATH_TO_SELECT_AREA)).click();
            driver.findElements(By.className(Constants.PATH_TO_SELECTION)).get(1).click();
        }

        public static void pickCategory (WebDriver driver) {
            driver.findElement(By.xpath(Constants.PATH_TO_SELECT_CATEGORY)).click();
            driver.findElements(By.className(Constants.PATH_TO_SELECTION)).get(1).click();
        }

        public static void pressSearch (WebDriver driver) {
            driver.findElement(By.xpath(Constants.PATH_TO_SEARCH_BUTTON)).click();
        }
}

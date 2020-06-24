import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;


public class RegScreen {


    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddhhmmss");
    static String dateAsString = simpleDateFormat.format(new Date());


    public static void pressEnter(WebDriver driver){
        driver.findElement(By.xpath(Constants.PATH_TO_ENTER_BUTTON)).click();
    }

    public static void pressRegistration (WebDriver driver){
        driver.findElement(By.xpath(Constants.PATH_TO_REG_BUTTON)).click();
    }

    public static void insertDetails (WebDriver driver){
        driver.findElement(By.xpath(Constants.PATH_TO_NAME)).sendKeys("Test");
        driver.findElement(By.xpath(Constants.PATH_TO_MAIL)).sendKeys("Test"+dateAsString+"@test.com");
        driver.findElement(By.xpath(Constants.PATH_TO_PASSWORD)).sendKeys("Aa123123");
        driver.findElement(By.xpath(Constants.PATH_TO_RE_PASSWORD)).sendKeys("Aa123123");
        driver.findElement(By.xpath(Constants.PATH_TO_SUBMIT_BUTTON)).click();
    }
}

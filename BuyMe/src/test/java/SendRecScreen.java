import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendRecScreen {

    public static void insertDetails (WebDriver driver) {
        driver.findElement(By.xpath(Constants.PATH_TO_RECEIVER)).sendKeys("Test");
        driver.findElement(By.xpath(Constants.PATH_TO_SENDER)).sendKeys("Test");
        driver.findElement(By.xpath(Constants.PATH_TO_EVENT)).click();
        driver.findElements(By.className(Constants.PATH_TO_EVENT_SELECTION)).get(1).click();
        driver.findElement(By.xpath(Constants.PATH_TO_TEXTAREA)).sendKeys("Test");
    }

    public static void uploadPhoto (WebDriver driver) {
        driver.findElement(By.xpath(Constants.PATH_TO_UPLOAD_PHOTO)).sendKeys("C:\\Users\\Ofer\\Desktop\\FULLER.png");
    }

    public static void howToSendGiftCard (WebDriver driver) {
        driver.findElement(By.xpath(Constants.PATH_TO_BY_MAIL)).click();
        driver.findElement(By.xpath(Constants.PATH_TO_EMAIL)).sendKeys("Test@Test.com");
        driver.findElement(By.xpath(Constants.PATH_TO_SAVE_BUTTON)).click();
    }

    public static void pressSubmit (WebDriver driver) {
        driver.findElement(By.xpath(Constants.PATH_TO_PAY_BUTTON)).click();
    }
}

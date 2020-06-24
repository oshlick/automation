import com.sun.deploy.cache.Cache;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.opentest4j.AssertionFailedError;
import org.w3c.dom.Document;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Main {

    public static WebDriver driver;

    // create ExtentReports and attach reporter(s)
    public static ExtentReports extent ;

    // creates a toggle for the given test, adds all log events under it
    public static ExtentTest test;

    public static Cache FileUtils;

    @BeforeClass
    public static void startBrowser() throws Exception {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Constants.LOG_HTML);

        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("MyFirstTest", "Sample description");

        // add custom system info
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("Tester", "Ofer");

        // log before class
        test.log(Status.INFO, "@Start Test Session");

        boolean driverEstablish = false;
        try {
            //get browser type from xml file
            String browserType = getData("browserType");

            //open browser
            if (browserType.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER);
                driver = new ChromeDriver();
            } else if (browserType.equals("Firefox")) {
                System.setProperty("webdriver.gecko.driver", Constants.FIREFOXDRIVER);
                driver = new FirefoxDriver();
            } else if (browserType.equals("IE")) {
                System.setProperty("webdriver.ie.driver", Constants.IEDRIVER);
                driver = new InternetExplorerDriver();
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.navigate().to(getData("url"));
            driverEstablish = true;

        } catch (Exception e) {
            e.printStackTrace();
            fail("Cant connect chromeDriver");
            test.log(Status.FATAL, "-----> Driver Connection Failed! " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver,"C:\\Users\\Ofer\\Documents\\QA AUTOMATION\\web project\\SCREENSHOTS\\" + "MAIN")).build());
            driverEstablish = false;
        } finally {
            if (driverEstablish) {
                String currentTime = String.valueOf(System.currentTimeMillis());
                test.log(Status.PASS, "-----> Driver established successfully", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver,"C:\\Users\\Ofer\\Documents\\QA AUTOMATION\\web project\\SCREENSHOTS\\" + "MAIN")).build());
            }
        }
    }


    @Test
    public void Test01_RegistarionScreen() throws IOException {
        // log test info
            test.log(Status.INFO, "@Test01_RegistrationScreen", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver,"C:\\Users\\Ofer\\Documents\\QA AUTOMATION\\web project\\SCREENSHOTS\\" + "REGSCREEN")).build());



        //enter the order sequence
            boolean pressEnter = false;
            try {
                RegScreen.pressEnter(driver);
                pressEnter = true;

            } catch (Exception e){
                e.printStackTrace();
                fail("Can't press enter button");
                test.log(Status.FATAL, "-----> enter failed" + e.getMessage());
                pressEnter = false;
            } finally {
                if (pressEnter){
                    test.log(Status.PASS, "-----> enter button pressed successfully");
                }
            }

        //enter the registration screen
            boolean pressRegistration = false;
            try{
                RegScreen.pressRegistration(driver);
                pressRegistration = true;
            } catch (Exception e){
                e.printStackTrace();
                fail("Can't press enter registration button");
                test.log(Status.FATAL, "-----> registration failed" + e.getMessage());
                pressRegistration = false;
            } finally {
                if (pressRegistration){
                    test.log(Status.PASS, "-----> registration button pressed successfully");
                }
            }


        //enter details
            Boolean insertDetails = false;
            try {
                RegScreen.insertDetails(driver);
                insertDetails = true;
            } catch (Exception e){
                e.printStackTrace();
                fail("Can't insert details");
                test.log(Status.FATAL, "-----> insert details failed" + e.getMessage());
                insertDetails = false;
            } finally {
                if (insertDetails){
                    test.log(Status.PASS, "-----> details inserted successfully");
                }
            }
    }

    @Test
    public void Test02_HomeScreen() throws InterruptedException, IOException {
        // log test info
        test.log(Status.INFO, "@Test02_HomeScreen", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver,"C:\\Users\\Ofer\\Documents\\QA AUTOMATION\\web project\\SCREENSHOTS\\" + "HOMESCREEN")).build());


        //select price
            boolean pickPrice = false;
            try {
                HomeScreen.pickPrice(driver);
                pickPrice = true;
            } catch (Exception e){
                e.printStackTrace();
                fail("Can't pick price");
                test.log(Status.FATAL, "-----> pick price failed" + e.getMessage());
                pickPrice = false;
            } finally {
                if (pickPrice){
                    test.log(Status.PASS, "-----> price picked successfully");
                }
            }

        //select area
            boolean pickArea = false;
            try {
                HomeScreen.pickArea(driver);
                pickArea = true;
            } catch (Exception e){
                e.printStackTrace();
                fail("Can't pick area");
                test.log(Status.FATAL, "-----> pick area failed" + e.getMessage());
                pickArea = false;
            } finally {
                if (pickArea){
                    test.log(Status.PASS, "-----> area pick successfully");
                }
            }

        //select category
            boolean pickCategory = false;
            try {
                HomeScreen.pickCategory(driver);
                pickCategory = true;
            } catch (Exception e){
                e.printStackTrace();
                fail("Can't pick category");
                test.log(Status.FATAL, "-----> pick category failed" + e.getMessage());
                pickCategory = false;
            } finally {
                if (pickCategory){
                    test.log(Status.PASS, "-----> category picked successfully");
                }
            }

        //submit
            boolean pressSearch = false;
            try {
                HomeScreen.pressSearch(driver);
                pressSearch = true;
            } catch (Exception e){
                e.printStackTrace();
                fail("Can't press search");
                test.log(Status.FATAL, "-----> press search failed" + e.getMessage());
                pressSearch = false;
            } finally {
                if (pressSearch){
                    test.log(Status.PASS, "-----> pressed search successfully");
                }
            }
    }

    @Test
    public void Test03_GiftScreen() {
        // log test info
        test.log(Status.INFO, "@Test03GiftScreen");

        //assert page url
        boolean assertURL = false;
        try {
            GiftScreen.assertURL(driver);
            assertURL = true;
        } catch (Exception e){
            e.printStackTrace();
            fail("URL's don't match");
            test.log(Status.FATAL, "-----> URL's don't match" + e.getMessage());
            assertURL  = false;
        } finally {
            if (assertURL){
                test.log(Status.PASS, "-----> URL's match");
            }
        }

        //pick a gift
        boolean pickGift = false;
        try {
            GiftScreen.pickGift(driver);
            pickGift = true;
        } catch (Exception e) {
            e.printStackTrace();
            fail("can't pick gift");
            test.log(Status.FATAL, "-----> pick gift failed" + e.getMessage());
            assertURL  = false;
        } finally {
            if (assertURL){
                test.log(Status.PASS, "-----> gift picked successfully");
            }
        }
    }

    @Test
    public void Test04_SendRecScreen(){
        // log test info
        test.log(Status.INFO, "@Test04_SendRecScreen");

        //insert receiver and sender details
            boolean insertDetails = false;
            try{
                SendRecScreen.insertDetails (driver);
                insertDetails = true;
            } catch (Exception e) {
                e.printStackTrace();
                fail("can't insert details");
                test.log(Status.FATAL, "-----> insert details failed" + e.getMessage());
                insertDetails  = false;
            } finally {
                if (insertDetails){
                    test.log(Status.PASS, "-----> details inserted successfully");
                }
            }

        //upload photo
            boolean uploadPhoto = false;
            try {
                SendRecScreen.uploadPhoto(driver);
                uploadPhoto = true;
            } catch (Exception e) {
                e.printStackTrace();
                fail("can't upload photo");
                test.log(Status.FATAL, "-----> upload photo failed" + e.getMessage());
                uploadPhoto  = false;
            } finally {
                if (uploadPhoto){
                    test.log(Status.PASS, "-----> uploaded photo successfully");
                }
            }

        //choose how to send the gift
            boolean howToSendGiftCard = false;
            try {
                SendRecScreen.howToSendGiftCard(driver);
                howToSendGiftCard = true;
            } catch (Exception e) {
                e.printStackTrace();
                fail("can't choose how to send gift card");
                test.log(Status.FATAL, "-----> choose how to send gift card failed" + e.getMessage());
                howToSendGiftCard  = false;
            } finally {
                if (howToSendGiftCard){
                    test.log(Status.PASS, "-----> choosed how to send gift card successfully");
                }
            }

        //submit
            boolean pressSubmit = false;
            try{
                SendRecScreen.pressSubmit(driver);
                pressSubmit = true;
            } catch (Exception e) {
                e.printStackTrace();
                fail("can't press submit");
                test.log(Status.FATAL, "-----> press submit failed" + e.getMessage());
                pressSubmit  = false;
            } finally {
                if (pressSubmit){
                    test.log(Status.PASS, "-----> pressed submit successfully");
                }
            }
    }

    @AfterClass
    public static void endTests(){
        // log endTests info
        test.log(Status.INFO, "@End Test Session");

        //end test and save data into report file
        driver.quit();
        extent.flush();

    }

    // get data from external xml file
    public static String getData(String keyName) throws Exception {
        File fXmlFile = new File(Constants.SETTINGS_XML);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

    //take screenshot
    public static String takeScreenShot(WebDriver driver, String ImagesPath) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try{
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }
}

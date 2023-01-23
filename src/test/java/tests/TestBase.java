package tests;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {


    private WebDriver driver;

    private String url;

    public static Logger logger = LoggerFactory.getLogger(TestBase.class);

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void init(){
        System.setProperty("webdriver.chrome.driver", "/Users/albertnurgaliev/Downloads/chromedriver");
        setDriver(new ChromeDriver());
        getDriver().get(url);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod(enabled = true)
    public void tearDown(){
        getDriver().quit();
    }

    @AfterMethod
    public void stopTest(ITestResult result){
        if (result.isSuccess()) {
            logger.info("PASSED: "+ result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: "+ result.getMethod().getMethodName());
           // String path = "screenshots/screen-"+System.currentTimeMillis()+".png";
           // takeScreenshot(path);
        }
    }

    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String takeScreenshot(String path) {
        File tmp = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(path);
        try {
            screenshot.createNewFile();
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
            return "";
        }
        return screenshot.getAbsolutePath();
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}

package tests.alertsFrameWindows;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.WindowsPage;
import tests.TestBase;

public class WindowsTests extends TestBase {

    @BeforeSuite
    public void setUpInternal(){
        super.setUrl("https://demoqa.com/browser-windows");

    }

    @Test
    public void testSimpleNewTab(){
        WindowsPage windowsPage = new WindowsPage(getDriver()).clickTabButton();
        Assert.assertEquals(windowsPage.getSampleHeading()
                .getText(), "This is a sample page");

    }

    @Test
    public void testNewWindow(){
        WindowsPage windowsPage = new WindowsPage(getDriver()).clickWindowButton();
        Assert.assertEquals(windowsPage.getSampleHeading()
                .getText(), "This is a sample page");

    }

    @Test
    public void testNewWindowMsg(){
        WindowsPage windowsPage = new WindowsPage(getDriver()).clickNewWindowMessage();
        Assert.assertEquals(windowsPage.getBody()
                .getText(), "Knowledge increases by sharing but not by saving. " +
                "Please share this website with your friends and in your organization.");

    }

}

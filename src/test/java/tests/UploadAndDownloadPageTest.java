package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.UploadAndDownloadPage;

public class UploadAndDownloadPageTest extends TestBase{

    @BeforeSuite
    public void setUpInternal(){
        super.setUrl("https://demoqa.com/upload-download");
    }

    @Test
    public void performKeyEventUsingRobotTest(){
        UploadAndDownloadPage page = new UploadAndDownloadPage(getDriver());
        page.performKeyEventUsingRobot();
        Assert.assertEquals(page.getUploadFilePath(),
                "C:\\fakepath\\D1.txt");
    }
}

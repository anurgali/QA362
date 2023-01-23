package tests.alertsFrameWindows;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.FramesPage;
import tests.TestBase;

public class FramesTests extends TestBase {


    @BeforeSuite
    public void setUpInternal(){
        super.setUrl("https://demoqa.com/nestedframes");
    }

    @Test
    public void simpleFrameTest() {
        System.out.println(new FramesPage(getDriver()).returnListOfFrames().getText());
    }
}

package tests.alertsFrameWindows;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.NestedFramesPage;
import tests.TestBase;

public class NestedFramesTests extends TestBase {

    @BeforeSuite
    public void setUpInternal(){
        super.setUrl("https://demoqa.com/nestedframes");
    }

    @Test
    public void testNestedFrames(){
        new NestedFramesPage(getDriver()).handleNestedFrames();
    }
}

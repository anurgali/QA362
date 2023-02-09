package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.ToolTipsPage;

public class ToolTipsPageTests extends TestBase{

    @BeforeSuite
    public void setUpInternal(){
        super.setUrl("https://demoqa.com/tool-tips");
    }


    @Test
    public void tooltipButtonTest(){
        ToolTipsPage toolTipsPage = new ToolTipsPage(getDriver());
        toolTipsPage.hoverToolTipButton();
        Assert.assertEquals(toolTipsPage.getToolTipText(), "You hovered over the Button");
    }



}

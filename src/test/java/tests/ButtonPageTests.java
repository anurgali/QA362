package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.ButtonsPage;

public class ButtonPageTests extends TestBase{

    @BeforeSuite
    public void setUpInternal(){
        super.setUrl("https://demoqa.com/buttons");
    }

    @Test
    public void doubleClickTest(){
        ButtonsPage buttonsPage = new ButtonsPage(getDriver());
        buttonsPage.doubleClick();
        sleep();
        String text = buttonsPage.getDoubleClickMsg();
        Assert.assertEquals(text,"You have done a double click");
    }

    @Test
    public void rightClickTest(){
        ButtonsPage buttonsPage = new ButtonsPage(getDriver());
        buttonsPage.rightClick();
        sleep();
        String text = buttonsPage.getRightClickMsg();
        Assert.assertEquals(text,"You have done a right click");
    }

    
}

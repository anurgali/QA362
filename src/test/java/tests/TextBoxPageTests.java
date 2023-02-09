package tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.TextBoxPage;

public class TextBoxPageTests extends TestBase{

    @BeforeSuite
    public void setUpInternal(){
        super.setUrl("https://demoqa.com/text-box");
    }

    @Test
    public void fillInTheFormTest(){
        TextBoxPage textBoxPage = new TextBoxPage(getDriver());
        textBoxPage.fillInTheForm();
    }
}

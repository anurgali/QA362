package tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.BrokenLinksPage;

public class BrokenLinksPageTests extends TestBase{

    @BeforeSuite
    public void setUpInternal(){
        super.setUrl("https://demoqa.com/broken");
    }


    @Test
    public void printLinks(){
        BrokenLinksPage page = new BrokenLinksPage(getDriver());
        page.printAllLinks();
    }

    @Test
    public void checkAllLinks(){
        BrokenLinksPage page = new BrokenLinksPage(getDriver());
        page.checkBrokenLinks();
    }

    @Test
    public void brokenImagesTest(){
        BrokenLinksPage page = new BrokenLinksPage(getDriver());
        page.checkBrokenImages();
    }
}

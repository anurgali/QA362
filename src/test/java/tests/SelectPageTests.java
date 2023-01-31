package tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.SelectMenuPage;

public class SelectPageTests extends TestBase{

    @BeforeSuite
    public void setUpInternal(){
        super.setUrl("https://demoqa.com/select-menu");
    }

    @Test
    public void simpleSelectTest(){
        SelectMenuPage selectMenuPage = new SelectMenuPage(getDriver());
        selectMenuPage.oldStyleMenu("Purple");
    }


    @Test
    public void multiSelectTest() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(getDriver());
        selectMenuPage.multiSelectDropdown("Black");
        selectMenuPage.deselect();
    }

    @Test
    public void multiSelectTest2() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(getDriver());
        selectMenuPage.multiSelectDropdown("Blue", "Black", "Red");
    }

    @Test
    public void standardMultiSelectTest(){
        SelectMenuPage selectMenuPage = new SelectMenuPage(getDriver());
        selectMenuPage.standardMultiSelect();
    }
}

package tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.interactions.DragAndDropPage;

public class DragAndDropTests extends TestBase{
    @BeforeSuite
    public void setUpInternal(){
        super.setUrl("https://demoqa.com/droppable");
    }

    @Test
    public void dragAndDropTest(){
        DragAndDropPage dd = new DragAndDropPage(getDriver());
        dd.actionDragMe();
    }


    @Test
    public void dragAndDropByTest(){
        DragAndDropPage dd = new DragAndDropPage(getDriver());
        dd.actionDragBy();
    }

    ////x=652 y=332
    @Test
    public void dragAndDropByTest2(){
        DragAndDropPage dd = new DragAndDropPage(getDriver());
        dd.actionDragByIndex(318,22);
    }
}

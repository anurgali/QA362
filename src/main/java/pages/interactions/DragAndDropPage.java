package pages.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class DragAndDropPage extends PageBase {

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;

    public DragAndDropPage actionDragMe(){
        Actions actions=new Actions(getDriver());
        actions.dragAndDrop(dragMe, dropHere).perform();
        String text = dropHere.getText();
        System.out.println(text);
        return this;
    }

    public DragAndDropPage actionDragBy(){
        Actions actions=new Actions(getDriver());
        int xOffset = dragMe.getLocation().getX();
        int yOffset = dragMe.getLocation().getY();
        System.out.println("x="+xOffset+" y="+yOffset);
        int xoffset1 = dropHere.getLocation().getX();
        int yoffset1 = dropHere.getLocation().getY();


        xoffset1 = (xoffset1 - xOffset)+20;
        yoffset1 = (yoffset1 - yOffset)+30;
        System.out.println("x="+xoffset1+" y="+yoffset1);
        sleep();
        actions.dragAndDropBy(dragMe, xoffset1, yoffset1).perform();

        System.out.println(dropHere.getText());
        return this;
    }


    public DragAndDropPage actionDragByIndex(int x, int y){
        Actions actions=new Actions(getDriver());
        actions.dragAndDropBy(dragMe, x, y). perform();
        sleep();
        return this;
    }
}

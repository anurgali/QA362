package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class UploadAndDownloadPage extends PageBase{

    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="uploadFile")
    WebElement uploadFile;

    @FindBy(id = "uploadFilePath")
    WebElement uploadFilePath;

    public UploadAndDownloadPage performKeyEventUsingRobot() {
        try{
            Robot robot = new Robot();
            Dimension i = getDriver().manage().window().getSize();
            //System.out.println("DIMENSION: "+ i.getWidth()+" "+ i.getHeight());
            int x= i.getWidth()/4+100;
            int y = i.getHeight()/4+250;
            robot.mouseMove(x,y);
            sleep();
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            sleep();

        } catch (AWTException e) {
            e.printStackTrace();
        }
        sleep();
        try {
            //D1.txt
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_SHIFT);
            sleep();
            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_1);
            robot.keyPress(KeyEvent.VK_PERIOD);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyPress(KeyEvent.VK_X);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyPress(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getUploadFilePath() {
        return uploadFilePath.getText();
    }
}

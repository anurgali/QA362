package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NestedFramesPage extends PageBase{
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> frames;

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(tagName = "body")
    WebElement body;

    public NestedFramesPage handleNestedFrames(){
        System.out.println("Number of frames: "+frames.size());
        System.out.println("Frame1 text: " + getDriver().switchTo().frame(frame1).findElement(By.tagName("body")).getText());
        getDriver().switchTo().frame(0);
        System.out.println("Frame2 text: " + body.getText());
        getDriver().switchTo().parentFrame();
        System.out.println("Parent Frame text: " + body.getText());
        return this;
    }

}

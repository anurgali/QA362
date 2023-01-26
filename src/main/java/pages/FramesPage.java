package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramesPage extends PageBase{


    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> frames;

    @FindBy(id = "frame1")
    WebElement frame1;

    private String text;

    public FramesPage returnListOfFrames(){
        System.out.println(frames.size());
        System.out.println(getDriver().switchTo().frame(frame1).findElement(By.id("sampleHeading")).getText());
        return this;
    }

    public void switchToFrameByIndex(int index) {
        //        text = driver.switchTo().frame(frame1).getText(); // switch by index
        getDriver().switchTo().frame(index);

    }

    public void switchToFrameById(WebElement frame) {
        getDriver().switchTo().frame(frame); // switch by id
        getDriver().switchTo().defaultContent();
    }

    public String getText() {
        return text;
    }
}

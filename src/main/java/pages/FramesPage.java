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

    @FindBy(css = "body:nth-child(2) > iframe:nth-child(2)")
    WebElement frame1;////iframe[@id='frame1']

    private String text;

    public FramesPage returnListOfFrames(){

        //System.out.println(frames.size());
        text = driver.switchTo().frame(frame1).getText(); // switch by index


//        driver.switchTo().frame(frame1); // switch by id

//        driver.switchTo().parentFrame(); // nested frames
        return this;
    }

    public String getText() {
        return text;
    }
}

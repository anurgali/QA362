package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsPage extends PageBase{
    public WindowsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "tabButton")
    WebElement tabButton;

    @FindBy(id = "windowButton")
    WebElement windowButton;

    @FindBy(id="sampleHeading")
    WebElement sampleHeading;

    @FindBy(id="messageWindowButton")
    WebElement messageWindowButton;

    @FindBy(xpath = "//body")
    WebElement body;

    public WindowsPage clickTabButton(){
        clickButton(tabButton);
        return this;
    }

    public WindowsPage clickWindowButton(){
        clickButton(windowButton);
        return this;
    }

    public WindowsPage clickNewWindowMessage(){
        clickButton(messageWindowButton);
        return this;
    }

    public WindowsPage clickButton(WebElement button) {
        click(button);
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }


        //driver.switchTo().window(tabs.get(0));
        return this;
    }

    public WebElement getSampleHeading() {
        return sampleHeading;
    }

    public WebElement getBody() {
        return body;
    }
}

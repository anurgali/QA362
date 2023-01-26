package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends PageBase{
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "doubleClickBtn")
    WebElement doubleClickBtn;

    @FindBy (xpath = "//p[@id='doubleClickMessage']")
    WebElement doubleClickMessage;

    @FindBy(id="rightClickBtn")
    WebElement rightClickBtn;

    @FindBy (id = "rightClickMessage")
    WebElement rightClickMessage;

    public ButtonsPage doubleClick(){
        Actions actions = new Actions(getDriver());
        actions.doubleClick(doubleClickBtn).doubleClick(doubleClickBtn).perform();
        return this;
    }

    public String getDoubleClickMsg(){
        return doubleClickMessage.getText();
    }

    public ButtonsPage rightClick(){
        Actions actions = new Actions(getDriver());
        actions.contextClick(rightClickBtn).perform();
        return this;
    }

    public String getRightClickMsg(){
        return rightClickMessage.getText();
    }


}

package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends PageBase{

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElement currentAddress;

    @FindBy(xpath = "//p[@id='permanentAddress']")
    WebElement permanentAddress;

    @FindBy(id = "submit")
    WebElement submit;

    @FindBy(id = "name")
    WebElement name;

    @FindBy(id = "email")
    WebElement email;

    public TextBoxPage fillInTheForm(){
        type(userName, UserData.USER_NAME);
        sleep();
        type(userEmail, UserData.EMAIL);
        sleep();
        typeWithJSExecutor(currentAddress, "Elm str., 10", 0, 200);
        sleep();
        Actions actions = new Actions(getDriver());

        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
        sleep();
        actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
        sleep();
        actions.sendKeys(Keys.TAB).perform();
        sleep();
        actions.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
        sleep();

        clickWithJSExecutor(submit,0,200);
        sleep();
        System.out.println(name.getText());
        System.out.println(email.getText());
        System.out.println(currentAddress.getText());
        System.out.println(permanentAddress.getText());
        sleep();
        return this;
    }
}

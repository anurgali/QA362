package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends PageBase{

    @FindBy(xpath = "//a[contains(text(),'Main Item 2')]")
    WebElement mainItem;

    @FindBy(xpath = "//a[contains(text(),'SUB SUB LIST')]")
    WebElement subMenu1;

    @FindBy(xpath = "//a[contains(text(),'Sub Sub Item 2')]")
    WebElement subMenu2;

    private String mainItemText, subMenu1Text, subMenu2text;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public MenuPage hoverOverMenu(){
        Actions actions = new Actions(getDriver());

        actions.moveToElement(mainItem).perform();
        System.out.println(mainItem.getText());
        mainItemText = mainItem.getText();
        sleep();
        actions.moveToElement(subMenu1).perform();
        System.out.println(subMenu1.getText());
        subMenu1Text = subMenu1.getText();
        sleep();
        actions.moveToElement(subMenu2).perform();
        System.out.println(subMenu2.getText());
        subMenu2text = subMenu2.getText();
        sleep();
        return this;
    }

    public String getMainItemText() {
        return mainItemText;
    }

    public String getSubMenu1Text() {
        return subMenu1Text;
    }

    public String getSubMenu2text() {
        return subMenu2text;
    }

}

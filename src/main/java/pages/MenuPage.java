package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends PageBase{
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Main Item 2')]")
    WebElement mainItem;

    @FindBy(xpath = "//a[contains(text(),'SUB SUB LIST »')]")
    WebElement subMenu1;

    @FindBy(xpath = "//a[contains(text(),'Sub Sub Item 2')]")
    WebElement subMenu2;


    public MenuPage hoverOverMenu(){
        Actions actions = new Actions(getDriver());

        actions.moveToElement(mainItem).perform();
        System.out.println(mainItem.getText());

        actions.moveToElement(subMenu1).perform();
        System.out.println(subMenu1.getText());

        actions.moveToElement(subMenu2).perform();
        System.out.println(subMenu2.getText());
        return this;
    }
}

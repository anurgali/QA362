package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuPage extends PageBase{
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="oldSelectMenu")
    WebElement oldStyleMenu;

    public SelectMenuPage oldStyleMenu(String text){
        Select select = new Select(oldStyleMenu);
        select.selectByVisibleText(text);
        sleep();
        System.out.println(select.getFirstSelectedOption().getText());
        sleep();
        System.out.println("******");
        List<WebElement> options = select.getOptions();
        for (WebElement element :
                options) {
            System.out.println(element.getText());
        }
        System.out.println("******");
        return this;
    }


    @FindBy(xpath="(//div[@class=' css-1hwfws3'])[3]")
    WebElement multiSelect;

    @FindBy(xpath = "//html")
    WebElement space;

    public SelectMenuPage multiSelectDropdown(String text){
        clickWithJSExecutor(multiSelect, 0,300);
        WebElement element = getDriver().findElement(By.xpath(String.format("//div[text()='%s']",text)));
        click(element);
        sleep();
        click(space);
        return this;
    }

    @FindBy(css = ".css-xb97g8")
    WebElement deselect;

    public SelectMenuPage deselect(){
        click(deselect);
        sleep();
        return this;
    }


    @FindBy(id="react-select-4-input")
    WebElement inputSelect;

    public SelectMenuPage multiSelectDropdown(String text1, String text2, String text3){
        inputSelect.sendKeys(text1);
        inputSelect.sendKeys(Keys.ENTER);
        sleep();
        inputSelect.sendKeys(text2);
        inputSelect.sendKeys(Keys.ENTER);
        sleep();
        inputSelect.sendKeys(text3);
        inputSelect.sendKeys(Keys.ENTER);
        sleep();
        click(space);
        return this;
    }

    @FindBy(id="cars")
    WebElement cars;

    public SelectMenuPage standardMultiSelect(){
        Select multi = new Select(cars);
        if (multi.isMultiple()){
            multi.selectByIndex(0);
            multi.selectByIndex(3);
        }
        sleep();
        List<WebElement> list = multi.getAllSelectedOptions();
        for (WebElement car :
                list) {
            System.out.println(car.getText());
        }
        return this;
    }
}

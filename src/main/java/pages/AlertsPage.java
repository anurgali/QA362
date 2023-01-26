package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AlertsPage extends PageBase{


    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="alertButton")
    WebElement simpleAlertButton;

    public AlertsPage clickOnSimpleAlertButton(){
        click(simpleAlertButton);
        Alert alert = getDriver().switchTo().alert();
        //sleep();
        alert.accept();//OK
        return this;
    }

    @FindBy(id="timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage clickOnTimerAlertButton() {
        click(timerAlertButton);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        Alert myAlert= wait.until(ExpectedConditions.alertIsPresent());
        String alertMsg=myAlert.getText();
        System.out.println("alert="+alertMsg);
        myAlert.accept();
        return this;
    }

    @FindBy(id="confirmButton")
    WebElement confirmButton;

    public AlertsPage clickOnConfirmButton(String text) {
        click(confirmButton);
        if (text==null) {
            return this;
        }
        if (text.equals("Отмена")) {
            getDriver().switchTo().alert().dismiss();
        } else if (text.equals("OK")) {
            getDriver().switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id="confirmResult")
    WebElement confirmResult;
    public String getConfirmResult() {
        return confirmResult.getText();
    }

    @FindBy(id="promtButton")
    WebElement promtButton;
    public AlertsPage clickMessageAlertButton(String msg) {
        click(promtButton);
        if (msg != null) {
            getDriver().switchTo().alert().sendKeys(msg);
        }
        System.out.println(getDriver().switchTo().alert().getText());
        getDriver().switchTo().alert().accept();
        return this;
    }

    @FindBy(id="promptResult")
    WebElement promtResult;
    public String getConfirmMessageResult() {
        return promtResult.getText();
    }
}

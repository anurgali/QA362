package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//input[@name=\"email\"]")
    WebElement userName;

    @FindBy(xpath = "//input[@placeholder=\"Password\"]")
    WebElement password;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement loginButton;


    public ContactsPage login(String uName, String pass) {
        type(userName, uName);
        type(password, pass);
        click(loginButton);
        return new ContactsPage(driver);
    }

    public LoginPage loginNegative(String uName, String pass) {
        type(userName, uName);
        type(password, pass);
        click(loginButton);
        return this;
    }

}

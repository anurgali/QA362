package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStoreLoginPage extends PageBase{

    public BookStoreLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="userName")
    WebElement userName;

    @FindBy(id="password")
    WebElement pass;

    @FindBy(id="login")
    WebElement loginButton;

    public ProfilePage login(){
        type(userName, UserData.USER_NAME);
        type(pass, UserData.PASSWORD);
        click(loginButton);
        return new ProfilePage(driver);
    }

}

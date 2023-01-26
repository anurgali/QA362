package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends PageBase{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/ul[1]/li[2]/span[1]")
    WebElement bookstoreMenu;

    public BookStorePage scrollDownAndGoToBookStore() {
        clickWithJSExecutor(bookstoreMenu, 0, 150);
        return new BookStorePage(getDriver());
    }

    public BookStorePage goToBookStore(){
        click(bookstoreMenu);
        return new BookStorePage(getDriver());
    }

    @FindBy(xpath = "//button[contains(text(),'Delete All Books')]")
    WebElement deleteBooks;

    public ProfilePage deleteAllBooks() {
        clickWithJSExecutor(deleteBooks, 0, 100);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(1));
        Alert alert= wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return this;
    }
}

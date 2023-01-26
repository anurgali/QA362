package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends PageBase{

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class=\"btn btn-outline-warning text-white\"  and @xpath=\"2\"]")
    WebElement logOutButton;

    // @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contacts;

    @FindBy(xpath = "//select[@id='langSelect']")
    WebElement selectLang;

//    @FindBy(xpath = "//option[contains(text(),'English')]")
//    WebElement engLang;

    public LoginPage logout(){
        click(logOutButton);
        return new LoginPage(getDriver());
    }

    public WebElement getContacts(String lang) {
        String contactWord = getContactWord(lang);
        contacts = getDriver().findElement(By.xpath("//a[contains(text(),'"+contactWord+"')]"));
        return contacts;
    }

    public static String getContactWord(String lang) {
        logger.info("Language specified: " + lang);
        String contactWord = null;
        if (lang.equals("English")) {
            contactWord = "Contacts";
        } else if (lang.equals("Russian")) {
            contactWord = "Контакты";
        } else if (lang.equals("German")) {
            contactWord = "Kontakte";
        } else if (lang.equals("Ukraine")) {
            contactWord = "Контакти";
        } else {
            logger.error("Language not supported: "+ lang);
            throw new RuntimeException("Language not supported: "+ lang);
        }
        return contactWord;
    }

    public ContactsPage selectLanguage(String lang){
        click(selectLang);
        WebElement language = getDriver().findElement(By.xpath("//option[contains(text(),'"+lang+"')]"));
        click(language);
        return this;
    }
}

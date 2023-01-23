package tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.LoginPage;

@Ignore
public class LoginPageTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        logger.info("Starting login test");
        String language= System.getProperty("language");
        LoginPage myLoginPage = new LoginPage(getDriver());
        ContactsPage contactsPage = myLoginPage.login("test@gmail.com", "test@gmail.com");
        sleep();
        contactsPage.selectLanguage(language);
        sleep();
        Assert.assertEquals(contactsPage.getContacts(language).getText(), ContactsPage.getContactWord(language));
        logger.info("Finished login test");
    }
}

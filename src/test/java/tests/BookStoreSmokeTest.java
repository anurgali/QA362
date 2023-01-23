package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.BookStoreLoginPage;
import pages.BookStorePage;
import pages.ProfilePage;
import pages.UserData;

public class BookStoreSmokeTest extends TestBase{

    @BeforeSuite
    public void setUpInternal(){
        super.setUrl("https://demoqa.com/login");
    }

    @Test
    public void smokeTest(){
        BookStoreLoginPage loginPage = new BookStoreLoginPage(getDriver());
        ProfilePage profile = loginPage.login();
        sleep();
        BookStorePage bs = profile.scrollDownAndGoToBookStore();
        sleep();
        bs.searchBook(UserData.BOOK_NAME);
        bs.selectBook(bs.getBook());
        bs.addToCollection();
        Assert.assertEquals(bs.getBookAddedMsg(), UserData.EXPECTED1);
        bs.addToCollection();
        Assert.assertEquals(bs.getBookAddedMsg(), UserData.EXPECTED2);
    }

    @AfterMethod
    public void cleanUp(){
        ProfilePage profile = new ProfilePage(getDriver());
        profile.deleteAllBooks();

    }
}

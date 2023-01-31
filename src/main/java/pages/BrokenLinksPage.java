package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class BrokenLinksPage extends PageBase{
    public BrokenLinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> links;

    public BrokenLinksPage checkAllLinks(){
        System.out.println("total links = "+ links.size());
        String url="";
        Iterator<WebElement> iterator = links.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    public BrokenLinksPage checkBrokenLinks() {
        for (int i = 0; i<links.size(); i++) {
            WebElement element = links.get(0);
            String url = element.getAttribute("href");
            verifyUrls(url);
        }
        return this;
    }

    private void verifyUrls(String link) {
        try{
            URL url = new URL(link);
            HttpURLConnection httpConn=(HttpURLConnection) url.openConnection();
            httpConn.setConnectTimeout(5000);
            httpConn.connect();
            if (httpConn.getResponseCode() >= 400){
                System.out.println(link + " is broken: " + httpConn.getResponseMessage());
            } else {
                System.out.println(link + " is OK");
            }
        } catch (Exception e) {
            System.out.println(link + " is broken: "+ e.getMessage());
        }
    }

    @FindBy(tagName = "img")
    List<WebElement> images;

    public BrokenLinksPage checkBrokenImages() {
        for (int i =0 ; i<images.size(); i++) {
            WebElement image = images.get(i);
            String imageUrl = image.getAttribute("src");
            System.out.println("Url: "+ imageUrl);
            verifyUrls(imageUrl);
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) getDriver())
                        .executeScript("return (typeof arguments[0].naturalWidth != undefined &&" +
                                "arguments[0].naturalWidth>0);", image);
                if (imageDisplayed) {
                    System.out.println("Image is OK");
                } else {
                    System.out.println("Image is broken");
                }
            } catch (Exception e) {
                System.out.println(imageUrl + " is broken: "+ e.getMessage());
            }
        }
        return this;
    }
}

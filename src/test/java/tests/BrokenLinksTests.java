package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.MainPage;
import utils.TestBase;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BrokenLinksTests extends TestBase {

    @Test(priority = 3)
    public void checkBrokenLinksOnMainPage(){
        WebDriver driver = getCurrentBrowser();

        new MainPage(driver).openPage();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> iterator = links.iterator();

        List<WebElement> brokenLinks = new ArrayList<WebElement>();

        while (iterator.hasNext()){
            if (isBrokenLink(iterator.next()))
                brokenLinks.add(iterator.next());
        }

        Assert.assertTrue(brokenLinks.size() == 0);
    }

    private boolean isBrokenLink(WebElement link){
        String url = link.getAttribute("href");
        HttpURLConnection httpConn = null;
        int responseCode = 200;

        try{
            httpConn = (HttpURLConnection)(new URL(url).openConnection());
            httpConn.setRequestMethod("HEAD");
            httpConn.connect();
            responseCode = httpConn.getResponseCode();

            if (responseCode == 404){
                //System.out.println("Broken link: " + url);
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }
}

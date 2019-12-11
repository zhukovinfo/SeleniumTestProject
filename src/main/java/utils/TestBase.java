package utils;

import dataproviders.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class TestBase {
    private WebDriver driver;

    @BeforeMethod
    public void initBrowser() {
        long implicitlyWaitTime = new ConfigFileReader().getImplicitlyWait();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownBrowser(){
        driver.quit();
    }

    protected WebDriver getCurrentBrowser(){
        return driver;
    }
}

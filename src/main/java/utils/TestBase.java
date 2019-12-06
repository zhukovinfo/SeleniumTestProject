package utils;

import dataproviders.ConfigFileReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;

    public void initBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(new ConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);
    }

    public void takeScreenshot(String testName){
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        String currentDateTime = new SimpleDateFormat("MM-dd-yyyy_hh-mm-ss").format((new Date()));

        try {
            FileUtils.copyFile(sourceFile,
                    new File("failed-screenshots/"+testName+"_"+currentDateTime+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {
    public static WebDriver driver;

    public void initBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void takeScreenshot(String testName){
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        String currentDateTime = new SimpleDateFormat("MM-dd-yyyy_hh_mm_ss").format((new Date()));

        try {
            FileUtils.copyFile(sourceFile,
                    new File("test-output/failed-screenshots/"+testName+"_"+currentDateTime+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

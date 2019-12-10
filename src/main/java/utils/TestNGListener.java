package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNGListener implements ITestListener {
    private WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        driver =  ((TestBase) currentClass).getCurrentBrowser();
        takeScreenshot(driver, result.getMethod().getMethodName());
    }

    private void takeScreenshot(WebDriver driver, String testName){
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


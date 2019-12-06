package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener extends TestBase implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot(result.getMethod().getMethodName());
    }

}


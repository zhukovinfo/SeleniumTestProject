package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class Page {

    protected WebDriver driver;

    protected Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForElement(WebDriver driver, WebElement webElement){
        return new WebDriverWait(driver, 20).
                until(ExpectedConditions.visibilityOf(webElement));
    }

    protected List<WebElement> waitForElements(WebDriver driver, List<WebElement> webElementList){
        return new WebDriverWait(driver, 20).
                until(ExpectedConditions.visibilityOfAllElements(webElementList));
    }
}

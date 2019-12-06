package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {
    private static String MAIN_PAGE_URL = "https://azure.microsoft.com/en-us/";

    protected WebDriver driver;

    @FindBy(id="navigation-pricing")
    protected WebElement pricingNavigationLink;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public MainPage openPage(){
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public PricingPage clickPricing(){
        pricingNavigationLink = waitForElement(driver, pricingNavigationLink);
        pricingNavigationLink.click();

        return new PricingPage(driver);
    }

}

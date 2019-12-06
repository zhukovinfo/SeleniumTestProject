package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingPage extends Page {
    private WebDriver driver;

    @FindBy(linkText = "Pricing calculator")
    private WebElement pricingCalculatorLink;

    public PricingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public PricingCalculatorPage clickPricingCalculator(){
        pricingCalculatorLink = waitForElement(driver, pricingCalculatorLink);
        pricingCalculatorLink.click();

        return new PricingCalculatorPage(driver);
    }
}

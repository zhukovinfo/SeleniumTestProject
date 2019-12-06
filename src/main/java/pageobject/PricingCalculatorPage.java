package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

public class PricingCalculatorPage extends Page {
    private WebDriver driver;

    @FindBy(xpath = "//button[@title='Virtual Machines']")
    protected WebElement virtualMachinesButton;

    @FindBy(xpath = "//div[contains(@id, 'virtual-machines')]")
    protected WebElement virtualMachinesModule;

    @FindBy(xpath="//button[@title='Storage Accounts']")
    protected WebElement storageAccountButton;

    @FindBy(xpath = "//div[contains(@id, 'storage-')]")
    protected WebElement storageAccountModule;

    @FindBy(xpath="//button[@title='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath="//button[@title='Clone']")
    private WebElement cloneButton;

    public PricingCalculatorPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public PricingCalculatorPage clickVirtualMachines(){
        WebElement button = waitForElement(driver, virtualMachinesButton);
        button.click();
        return this;
    }

    public PricingCalculatorPage selectVirtualMachinesRegion(String text){
        selectDropDownOption(virtualMachinesModule, "region", text);
        return this;
    }

    public PricingCalculatorPage selectVirtualMachinesOperatingSystem(String text){
        selectDropDownOption(virtualMachinesModule, "operatingSystem", text);
        return this;
    }

    public PricingCalculatorPage selectVirtualMachinesType(String text){
        selectDropDownOption(virtualMachinesModule, "type", text);
        return this;
    }

    public PricingCalculatorPage selectVirtualMachinesTier(String text){
        selectDropDownOption(virtualMachinesModule, "tier", text);
        return this;
    }

    public PricingCalculatorPage selectVirtualMachinesInstance(String text){
        selectDropDownOption(virtualMachinesModule, "size", text);
        return this;
    }

    public PricingCalculatorPage clickVirtualMachinesOneYearBillingOption(){
        clickOneYearBillingOption(virtualMachinesModule);
        return this;
    }

    public PricingCalculatorPage typeVirtualMachinesCount(int count){
        typeCount(virtualMachinesModule, count);
        return this;
    }

    public String getVirtualMachineCostPerMonth(){
        virtualMachinesModule = waitForElement(driver, virtualMachinesModule);
        return getTotal(virtualMachinesModule);
    }

    private String getTotal(WebElement productModule){
        productModule = waitForElement(driver,productModule);
        String total = productModule.findElements(By.xpath("//span[@class='numeric']/span")).get(0).getText();

        return total;
    }

    private void typeCount(WebElement productModule, int count){
        productModule = waitForElement(driver,productModule);
        WebElement input = waitForElement(driver, productModule.findElement(By.name("count")));

        input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        input.sendKeys(Integer.toString(count));
    }

    private void clickOneYearBillingOption(WebElement productModule){
        productModule = waitForElement(driver, productModule);
        WebElement radio= waitForElement(driver, productModule.findElement(By.xpath("//input[@value='one-year']")));
        radio.click();
    }

    private void selectDropDownOption(WebElement productModule, String dropdownName, String visibleText){
        productModule = waitForElement(driver, productModule);
        WebElement dropDown = waitForElement(driver, productModule.findElement(By.name(dropdownName)));

        Select select = new Select(dropDown);
        select.selectByVisibleText(visibleText);
    }

    public PricingCalculatorPage clickStorageAccount() {
        waitForElement(driver, storageAccountButton).click();
        return this;
    }

    public PricingCalculatorPage selectStorageAccountRegion(String text){
        storageAccountModule = waitForElement(driver, storageAccountModule );
        selectDropDownOption(storageAccountModule, "region", text);
        return this;
    }

    public PricingCalculatorPage selectStorageAccountType(String text){
        storageAccountModule = waitForElement(driver, storageAccountModule );
        selectDropDownOption(storageAccountModule, "type", text);
        return this;
    }

    public PricingCalculatorPage selectStorageAccountPerformanceTier(String text){
        storageAccountModule = waitForElement(driver, storageAccountModule );
        selectDropDownOption(storageAccountModule, "performanceTier", text);
        return this;
    }

    public PricingCalculatorPage selectStorageAccountStorageAccountType(String text){
        storageAccountModule = waitForElement(driver, storageAccountModule );
        selectDropDownOption(storageAccountModule, "storageAccountType", text);
        return this;
    }

    public PricingCalculatorPage selectStorageAccountRedundancy(String text){
        storageAccountModule = waitForElement(driver, storageAccountModule );
        selectDropDownOption(storageAccountModule, "redundancy", text);
        return this;
    }

    public PricingCalculatorPage selectStorageAccountAccessTier(String text){
        storageAccountModule = waitForElement(driver, storageAccountModule );
        selectDropDownOption(storageAccountModule, "accessTier", text);
        return this;
    }

    public PricingCalculatorPage clickStorageAccountPayAsYouGoString (String text){
        storageAccountModule = waitForElement(driver, storageAccountModule );
        selectDropDownOption(storageAccountModule, "accessTier", text);
        return this;
    }

    public PricingCalculatorPage typeStorageAccountCount(int count){
        storageAccountModule = waitForElement(driver, storageAccountModule );
        WebElement input = waitForElement(driver,
                storageAccountModule.findElement(By.name("premiumStorageCapacity")));

        input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        input.sendKeys(Integer.toString(count));
        return this;
    }

    public String getStorageAccountCostPerMonth(){
        storageAccountModule = waitForElement(driver, storageAccountModule );
        return getTotal(storageAccountModule);
    }

    public String getProductModuleName(){
        return waitForElement(driver,
                driver.findElement(By.xpath("//span[@class='module_name']/button"))).getText();
    }

    public PricingCalculatorPage clickDeleteButton(){
        waitForElement(driver, deleteButton).click();
        return this;
    }

    public PricingCalculatorPage clickCloneButton(){
        waitForElement(driver, cloneButton).click();
        return this;
    }

    public List<WebElement> getProductModuleNames(){
         return waitForElements(driver, driver.findElements(By.xpath("//span[@class='module-name']/button")));
    }
}

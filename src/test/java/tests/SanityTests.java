package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.MainPage;
import utils.*;

import java.util.List;

@Listeners(TestNGListener.class)
public class SanityTests extends TestBase {

    @Test
    public void addVMCalculation(){
        WebDriver driver = getCurrentBrowser();

        List<WebElement> modules = new MainPage(driver)
                .openPage()
                .clickPricing()
                .clickPricingCalculator()
                .clickVirtualMachines()
                .getProductModuleNames();

        Assert.assertEquals(modules.size(), 1);
        Assert.assertEquals(modules.get(0).getText(), "Virtual Machines");
    }

    @Test(priority = 1)
    public void deleteVMCalculation(){
        WebDriver driver = getCurrentBrowser();

        int countOfModules = new MainPage(driver)
                .openPage()
                .clickPricing()
                .clickPricingCalculator()
                .clickVirtualMachines()
                .clickDeleteButton()
                .getProductModuleNames().size();

        Assert.assertEquals(countOfModules, 0);
    }

    @Test(priority = 1)
    public void cloneVMCalculation(){
        WebDriver driver = getCurrentBrowser();

        List<WebElement> modules = new MainPage(driver)
                .openPage()
                .clickPricing()
                .clickPricingCalculator()
                .clickVirtualMachines()
                .clickCloneButton()
                .getProductModuleNames();

        Assert.assertEquals(modules.size(), 2);
        Assert.assertEquals(modules.get(0).getText(),"Virtual Machines");
        Assert.assertEquals(modules.get(1).getText(),"Virtual Machines");
    }

}

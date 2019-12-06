package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.*;
import utils.*;

@Listeners(TestNGListener.class)
public class PricingCalculatorTests extends TestBase {

    @BeforeMethod
    public void setUp(){
        initBrowser();
    }

    @Test(priority = 2)
    public void calculateVMBillingCostWithOneYearReserved(){
        String costPerMonth = new MainPage(driver)
                .openPage()
                .clickPricing()
                .clickPricingCalculator()
                .clickVirtualMachines()
                .selectVirtualMachinesRegion("East US")
                .selectVirtualMachinesOperatingSystem("Linux")
                .selectVirtualMachinesType("CentOS")
                .selectVirtualMachinesTier("Standard")
                .selectVirtualMachinesInstance("B2S: 2 vCPU(s), 4 GB RAM, 8 GB Temporary storage, $0.0416/hour")
                .clickVirtualMachinesOneYearBillingOption()
                .typeVirtualMachinesCount(2)
                .getVirtualMachineCostPerMonth();

         Assert.assertEquals(costPerMonth, "$35.51\nEffective cost per month");
    }

    @Test(priority = 2)
    public void calculateStorageAccountBillingCostPayAsYouGo(){
        String costPerMonth = new MainPage(driver)
                .openPage()
                .clickPricing()
                .clickPricingCalculator()
                .clickStorageAccount()
                .selectStorageAccountRegion("UK West")
                .selectStorageAccountType("File Storage")
                .selectStorageAccountPerformanceTier("Premium")
                .selectStorageAccountRedundancy("ZRS")
                .typeStorageAccountCount(1100)
                .getStorageAccountCostPerMonth();

        Assert.assertEquals(costPerMonth,"$399.30");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

package allovercommerce.tests.US_20;

import allovercommerce.pages.HomePageUS19_20;
import allovercommerce.pages.StoreManagerPageUS19_20;
import allovercommerce.pages.VendorMyAccountPageUS19_20;
import allovercommerce.tests.US_19.US_19_TC_02;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_20_TC_01 {
    US_19_TC_02 us_19_tc_02 = new US_19_TC_02();
    HomePageUS19_20 homePage = new HomePageUS19_20();
    VendorMyAccountPageUS19_20 vendorMyAccountPage = new VendorMyAccountPageUS19_20();
    StoreManagerPageUS19_20 storeManagerPage = new StoreManagerPageUS19_20();

    public void addCoupon(){
        //        Vendor clicks "My Account" button
        JSUtils.clickElementByJS(homePage.MyAccountLink);

//        verify "Hello sasusa.odupog (not sasusa.odupog? Log out)"  message is displayed
        Assert.assertTrue(vendorMyAccountPage.greetingMessage.isDisplayed());

//        vendor clicks on store manager link
        vendorMyAccountPage.storeManager.click();

//        verify the url is https://allovercommerce.com/store-manager/
        String expectedUrl = "https://allovercommerce.com/store-manager/";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),expectedUrl);

//        vendor clicks coupon link
        JSUtils.clickElementByJS(storeManagerPage.coupons);

//        verify  Coupons Listing text is displayed
        Assert.assertTrue(storeManagerPage.couponsListing.isDisplayed());

//        vendor clicks add new button
        storeManagerPage.addNewCouponButton.click();
//        verify Add Coupon text is visible
        Assert.assertTrue(storeManagerPage.addCouponText.isDisplayed());

    }

    @Test
    public void addCouponCodeTest() {

        us_19_tc_02.vendorLogin();
        addCoupon();


//        vendor writes a code in code box
        storeManagerPage.code.sendKeys("xyz03");

//        verify code is displayed in the box
        String expectedText= "xyz03";
        String actualText = JSUtils.getValueInStringByJS("title");
        Assert.assertEquals(actualText,expectedText);

    }
}

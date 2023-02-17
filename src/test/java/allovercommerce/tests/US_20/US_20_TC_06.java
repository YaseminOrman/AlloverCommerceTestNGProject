package allovercommerce.tests.US_20;

import allovercommerce.pages.HomePageUS19_20;
import allovercommerce.pages.StoreManagerPageUS19_20;
import allovercommerce.pages.VendorMyAccountPageUS19_20;
import allovercommerce.tests.US_19.US_19_TC_02;
import allovercommerce.utilities.JSUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_20_TC_06 {

    US_19_TC_02 us_19_tc_02 = new US_19_TC_02();
    US_20_TC_01 us_20_tc_01 = new US_20_TC_01();
    HomePageUS19_20 homePage = new HomePageUS19_20();
    VendorMyAccountPageUS19_20 vendorMyAccountPage = new VendorMyAccountPageUS19_20();
    StoreManagerPageUS19_20 storeManagerPage = new StoreManagerPageUS19_20();

    @Test
    public void clickCouponDataTest() {

        us_19_tc_02.vendorLogin();
        us_20_tc_01.addCoupon();

        //        verify allow free shipping is clickable
        JSUtils.scrollIntoViewJS(storeManagerPage.free_shipping);

        if (!storeManagerPage.free_shipping.isSelected()){
            JSUtils.clickElementByJS(storeManagerPage.free_shipping);
        }

        Assert.assertTrue(storeManagerPage.free_shipping.isSelected());

        //        verify show on store is clickable
        JSUtils.scrollIntoViewJS(storeManagerPage.show_on_store);

        if (!storeManagerPage.show_on_store.isSelected()){
            JSUtils.clickElementByJS(storeManagerPage.show_on_store);
        }

        Assert.assertTrue(storeManagerPage.show_on_store.isSelected());

    }
}

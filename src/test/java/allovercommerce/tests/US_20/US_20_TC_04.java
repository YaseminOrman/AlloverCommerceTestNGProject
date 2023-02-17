package allovercommerce.tests.US_20;

import allovercommerce.pages.HomePageUS19_20;
import allovercommerce.pages.StoreManagerPageUS19_20;
import allovercommerce.pages.VendorMyAccountPageUS19_20;
import allovercommerce.tests.US_19.US_19_TC_02;
import allovercommerce.utilities.JSUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_20_TC_04 {

    US_19_TC_02 us_19_tc_02 = new US_19_TC_02();
    US_20_TC_01 us_20_tc_01 = new US_20_TC_01();
    HomePageUS19_20 homePage = new HomePageUS19_20();
    VendorMyAccountPageUS19_20 vendorMyAccountPage = new VendorMyAccountPageUS19_20();
    StoreManagerPageUS19_20 storeManagerPage = new StoreManagerPageUS19_20();

    @Test
    public void adCouponAmountTest() {
        us_19_tc_02.vendorLogin();
        us_20_tc_01.addCoupon();

       JSUtils.scrollIntoViewJS(storeManagerPage.couponAmount);

//        vendor enters coupon amount
        JSUtils.clickElementByJS(storeManagerPage.couponAmount);
        JSUtils.setValueByJS(storeManagerPage.couponAmount,"100");


//        verify amount is displayed in amount box

        String actualText =JSUtils.getValueInStringByJS("coupon_amount");
        Assert.assertTrue(actualText.contains("100"));



    }
}
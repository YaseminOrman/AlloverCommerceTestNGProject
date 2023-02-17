package allovercommerce.tests.US_20;

import allovercommerce.pages.HomePageUS19_20;
import allovercommerce.pages.StoreManagerPageUS19_20;
import allovercommerce.pages.VendorMyAccountPageUS19_20;
import allovercommerce.tests.US_19.US_19_TC_02;
import allovercommerce.utilities.JSUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_20_TC_03 {
    US_19_TC_02 us_19_tc_02 = new US_19_TC_02();
    US_20_TC_01 us_20_tc_01 = new US_20_TC_01();
    HomePageUS19_20 homePage = new HomePageUS19_20();
    VendorMyAccountPageUS19_20 vendorMyAccountPage = new VendorMyAccountPageUS19_20();
    StoreManagerPageUS19_20 storeManagerPage = new StoreManagerPageUS19_20();

    @Test
    public void selectCouponDiscountTypeTest() {
        us_19_tc_02.vendorLogin();
        us_20_tc_01.addCoupon();

        JSUtils.scrollIntoViewJS(storeManagerPage.discount_type);

//        vendor selects "percentage discount" type
        Select select = new Select(storeManagerPage.discount_type);
        select.selectByIndex(0);

//        verify discount types are selectable
        String actualSelectedOption = select.getFirstSelectedOption().getText();
        String expectedSelectedOption = "Percentage discount";
        Assert.assertEquals(actualSelectedOption,expectedSelectedOption);

//      vendor selects "fixed product discount" type
        select.selectByIndex(1);

//      verify second option is selected
        String actualSelectedOption2 = select.getFirstSelectedOption().getText();
        String expectedSelectedOption2 = "Fixed Product Discount";
        Assert.assertEquals(actualSelectedOption2,expectedSelectedOption2);
    }
}

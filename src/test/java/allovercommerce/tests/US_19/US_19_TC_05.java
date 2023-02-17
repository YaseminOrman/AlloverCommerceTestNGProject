package allovercommerce.tests.US_19;

import allovercommerce.pages.*;
import allovercommerce.utilities.JSUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_19_TC_05 {

    US_19_TC_02 us_19_tc_02 = new US_19_TC_02();
    HomePageUS19_20 homePage = new HomePageUS19_20();
    LoginPageUS19_20 loginPage = new LoginPageUS19_20();
    VendorMyAccountPageUS19_20 vendorMyAccountPage = new VendorMyAccountPageUS19_20();
    VendorShoppingPageUS19_20 vendorShoppingPage = new VendorShoppingPageUS19_20();
    VendorCheckOutPageUS19_20 vendorCheckOutPage = new VendorCheckOutPageUS19_20();

    @Test
    public void selectPaymentOptionTest() {

        us_19_tc_02.vendorLogin();
        us_19_tc_02.addMacBookIntoCart();

//        verify payment options are selectable
        JSUtils.clickElementByJS(vendorCheckOutPage.wireTransfer);
        Assert.assertTrue(vendorCheckOutPage.wireTransfer.isSelected());

        JSUtils.clickElementByJS(vendorCheckOutPage.payAtTheDoor);
        Assert.assertTrue(vendorCheckOutPage.payAtTheDoor.isSelected());
    }
}

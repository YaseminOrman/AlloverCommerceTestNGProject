package allovercommerce.tests.us11;

import allovercommerce.pages.HomePageUS_09;
import allovercommerce.pages.VendorMyAccountPageUS_11;
import allovercommerce.pages.VendorRegistrationPageUS_09;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class US_11_TC_05 {

/*
    US_11 : User should be able to sign in as a Vendor. (Vendor Sign in)
    Email and password should be entered as 'Vendor' and My Accout should be visible.
    Orders, Downloads, addresses, account details,whislist ve Logout should be visible.
    Store manager, orders, downloads, addresses , account details, wishlist, Support tickets, followings ve log out should be visible in Dashboard.  */


    VendorRegistrationPageUS_09 vendorRegistrationPageUS_09 = new VendorRegistrationPageUS_09();
    HomePageUS_09 homePageUS_09 = new HomePageUS_09();
    VendorMyAccountPageUS_11 vendorMyAccountPageUS_11 = new VendorMyAccountPageUS_11();
    Actions actions = new Actions(Driver.getDriver());




    @Test
    public void test_US_11_TC_05() throws IOException {

        // STEP: Store manager, orders, downloads, addresses , account details, wishlist, Support tickets, followings ve logout should be visible in Dashboard.

        //User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //Click on "Sign In" button
        homePageUS_09.singInButton.click();

        //Click on username text box and enter an exist username
        vendorRegistrationPageUS_09.existVendorUsername.sendKeys(ConfigReader.getProperty("exist_vendor_email"));

        //Click on password text box and enter a valid password
        vendorRegistrationPageUS_09.existVendorPassword.sendKeys(ConfigReader.getProperty("exist_vendor_password"));

        //Click on "Sign In" Button
        vendorRegistrationPageUS_09.existVendorSignInButton.click();

        //Click on "Sign Out" Button
        homePageUS_09.signOut.click();

        //Verify "Store Manager" icon is visible
        Assert.assertTrue(vendorMyAccountPageUS_11.storeManagerIcon.isEnabled());

        //Verify "Orders" icon is visible
        Assert.assertTrue(vendorMyAccountPageUS_11.ordersLeft.isEnabled());

        //Verify "Downloads" icon is visible
        Assert.assertTrue(vendorMyAccountPageUS_11.downloadsLeft.isEnabled());

        //Verify "Addresses" icon is visible
        Assert.assertTrue(vendorMyAccountPageUS_11.addressesLeft.isEnabled());

        //Verify "Account Details" icon is visible
        Assert.assertTrue(vendorMyAccountPageUS_11.accountDetailsLeft.isEnabled());

        //Verify "Wishlist" icon is visible
        Assert.assertTrue(vendorMyAccountPageUS_11.wishlistLeft.isEnabled());

        //Verify "Support Tickets" icon is visible
        Assert.assertTrue(vendorMyAccountPageUS_11.supportTickets.isEnabled());

        //Verify "Followings" icon is visible
        Assert.assertTrue(vendorMyAccountPageUS_11.followings.isEnabled());

        //Verify "Logout" icon is visible
        Assert.assertTrue(vendorMyAccountPageUS_11.logoutLeft.isEnabled());
        ReusableMethods.getScreenshot("test_US_11_TC_05");

        Driver.getDriver().close();

    }

}
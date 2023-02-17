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


public class US_11_TC_03 {

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
    public void test_US_11_TC_03() throws IOException {

        // STEP: Email and password should be entered as 'Vendor' and My Account should be visible.

        //User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //Click on "Sign In" button
        homePageUS_09.singInButton.click();

        //Click on username text box and enter an invalid username
        vendorRegistrationPageUS_09.existVendorUsername.sendKeys(ConfigReader.getProperty("registration_invalid_email"));

        //Click on password text box and enter a password
        vendorRegistrationPageUS_09.existVendorPassword.sendKeys(ConfigReader.getProperty("good_password"));

        //Click on "Sign In" Button
        vendorRegistrationPageUS_09.existVendorSignInButton.click();

        //Verify "Wrong username or password." text is visible
        Assert.assertTrue(homePageUS_09.wrongUsernameOrPassword.isDisplayed());
        ReusableMethods.getScreenshot("test_US_11_TC_03");

        Driver.getDriver().close();
    }


}
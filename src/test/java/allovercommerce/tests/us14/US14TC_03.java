package allovercommerce.tests.us14;

import allovercommerce.pages.HomePageUS_12;
import allovercommerce.pages.LoginPageUS_12;
import allovercommerce.pages.StoreManagerPageUS_14;
import allovercommerce.pages.VendorMyAccountPageUS_12;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US14TC_03 {

    //  US_14 "User should be able to see the options to add items as a Vendor #1.
    //        (My Account > Store Manager > Product > Add New)"

    // Acceptance Criteria : There should be Simple Product, Variable Product, Grouped Product, External - Affiliate Product options.

    //  TC_03 - Dropdown menu should be collapsed, when user click  outside  the dropdown.

    /*
    Given User should navigate to Allover Commerce url
    When Click on sign in button
    And Enter username into username/email box
    And Enter password into password box
    And Click on sign in button
    And Click on user icon to navigate My Account page
    And Click on Store Manager to navigate to store manager url
    And Click on Products option
    And Click on Add New option
    And Click on dropdown to see all dropdown options
    And Click on a space field to collapse dropdown menu
    Then Verify dropdown menu has collapsed
     */

    HomePageUS_12 homePageUS_12 = new HomePageUS_12();
    LoginPageUS_12 loginPageUS_12 = new LoginPageUS_12();

    VendorMyAccountPageUS_12 vendorMyAccountPageUS_12 = new VendorMyAccountPageUS_12();

    StoreManagerPageUS_14 storeManagerPageUS_14 = new StoreManagerPageUS_14();

    public void login() {
        //    User should navigate to Allover Commerce url https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //    Click on sign in button
        homePageUS_12.singInButton.click();

        //    Enter username into username/email box
        loginPageUS_12.usernameInput.sendKeys(ConfigReader.getProperty("app_vendor_valid_email2"));

        //    Enter password into password box
        loginPageUS_12.passwordInput.sendKeys(ConfigReader.getProperty("app_vendor_valid_password2"));

        //    Click on sign in button
        loginPageUS_12.signInButton.click();
    }

    @Test
    public void TC_03() {

        login();

        //  Click on user icon to navigate My Account page
        JSUtils.clickElementByJS(homePageUS_12.signOutButton);

        //  Click on Store Manager to navigate to store manager url
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.storeManager);

        //  Click on Products option
        JSUtils.clickElementByJS(storeManagerPageUS_14.productsOption);

        //  Click on Add New option
        JSUtils.clickElementByJS(storeManagerPageUS_14.addNewButton);

        //   Click on dropdown to see all dropdown options
        JSUtils.clickElementByJS(storeManagerPageUS_14.productTypeDropdown);

        //  Click on a space field to collapse dropdown menu
        JSUtils.clickElementByJS(storeManagerPageUS_14.spaceField);

        //  Verify dropdown menu has collapsed
        ReusableMethods.waitFor(2);
        Select select = new Select(storeManagerPageUS_14.productTypeDropdown);
        Assert.assertFalse(select.getFirstSelectedOption().getText().equals("Variable Product"));


    }

    @AfterMethod
    public void tearDown(){
        //Driver.closeDriver();
    }
}

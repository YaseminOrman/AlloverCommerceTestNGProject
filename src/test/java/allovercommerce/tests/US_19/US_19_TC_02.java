package allovercommerce.tests.US_19;

import allovercommerce.pages.HomePageUS19_20;
import allovercommerce.pages.LoginPageUS19_20;
import allovercommerce.pages.VendorMyAccountPageUS19_20;
import allovercommerce.pages.VendorShoppingPageUS19_20;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_19_TC_02 {

    HomePageUS19_20 homePageUS19_20 = new HomePageUS19_20();
    LoginPageUS19_20 loginPage = new LoginPageUS19_20();
    VendorMyAccountPageUS19_20 vendorMyAccountPage = new VendorMyAccountPageUS19_20();
    VendorShoppingPageUS19_20 vendorShoppingPage = new VendorShoppingPageUS19_20();

    public void vendorLogin(){
        //        Vendor goes to "https://allovercommerce.com/ url"
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        ReusableMethods.waitFor(3);

//        Vendor clicks on "Sign in" button
        Object homePage;
        homePageUS19_20.singInButton.click();
        ReusableMethods.waitFor(3);
//        Vendor enters valid email address
        loginPage.usernameInput.sendKeys(ConfigReader.getProperty("app_vendor_valid_email4"));
//        Vendor enters valid password
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("app_vendor_valid_password4"));
//        Vendor clicks "sing in" button
        loginPage.signInButton.click();
//        Verify "sign out" button is visible
        Assert.assertTrue(homePageUS19_20.signOutButton.isDisplayed());

    }

    public void addMacBookIntoCart(){

        //        Vendor clicks "My Account" button
        JSUtils.clickElementByJS(homePageUS19_20.MyAccountLink);

//        Vendor clicks Orders button
        vendorMyAccountPage.orders.click();

//        Vendor clicks "BROWSER PRODUCTS" button
        vendorMyAccountPage.browseProducts.click();
        ReusableMethods.waitFor(4);

//        Verify the url is "https://allovercommerce.com/shop/"
        String expectedUrlShop = "https://allovercommerce.com/shop/";
        String actualUrlShop = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrlShop,expectedUrlShop);

//        Vendor clicks "16 ” MacBook Pro" product
        JSUtils.clickElementByJS(vendorShoppingPage.macbookLink);
        ReusableMethods.waitFor(4);

//        Verify the url is "https://allovercommerce.com/urun/16-macbook-pro/#
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("16-macbook-pro"));

//        Vendor clicks on "ADD TO CART"  button
        JSUtils.clickElementByJS(vendorShoppingPage.macBookAddToCart);
        ReusableMethods.waitFor(3);

//        click on shopping cart image
        vendorShoppingPage.cart.click();
        ReusableMethods.waitFor(2);

//        click on checkout button
        vendorShoppingPage.checkoutButton.click();
        ReusableMethods.waitFor(3);
    }

    @Test
    public void itemsVisibleInCartTest() {
        vendorLogin();
        addMacBookIntoCart();

        //        verify "Macbook Pro product" is visible  in shopping cart

         ReusableMethods.verifyElementDisplayed(vendorShoppingPage.macbook16InCart);

    }
}

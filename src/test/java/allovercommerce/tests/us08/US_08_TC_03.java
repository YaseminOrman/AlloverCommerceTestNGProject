package allovercommerce.tests.us08;

import allovercommerce.pages.HomePage06;
import allovercommerce.pages.LoginPage06;
import allovercommerce.pages.ShoppingCart06;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_08_TC_03 {
    HomePage06 homePage06 = new HomePage06();
    LoginPage06 loginPage06 = new LoginPage06();
    ShoppingCart06 shoppingCart06 = new ShoppingCart06();

    @Test
    public void TC_01() {

        //Go to "https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("app_homepage_url"));
        homePage06.singInButton.click();
        loginPage06.usernameInput.sendKeys(ConfigReader.getProperty("app_valid_username"));
        loginPage06.passwordInput.sendKeys(ConfigReader.getProperty("app_valid_password"));
        loginPage06.signInButton.click();
        homePage06.signOutButton.click();
        shoppingCart06.searchBox.click();
        shoppingCart06.searchBox.sendKeys("Comfortable Backpack", Keys.ENTER);
        JSUtils.clickElementByJS(shoppingCart06.submitButton);
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(shoppingCart06.comfortableBackpack);
        ReusableMethods.waitFor(2);
        shoppingCart06.addToWishList.click();
        shoppingCart06.searchBox.click();
        shoppingCart06.searchBox.sendKeys("Kitchen Table", Keys.ENTER);
        shoppingCart06.submitButton.click();
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(shoppingCart06.kitchenTable);
        ReusableMethods.waitFor(3);
        shoppingCart06.addToWishListKitchenTable.click();
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(shoppingCart06.wishListIcon);
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(shoppingCart06.wishListPage);
        ReusableMethods.verifyElementDisplayed(shoppingCart06.wishListPage);
        JSUtils.clickElementByJS(shoppingCart06.quickView);
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(shoppingCart06.plusButton);
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(shoppingCart06.minusButton);
        Assert.assertTrue(shoppingCart06.quickView.isDisplayed());

    }



    @AfterMethod
    public void tearDown() {

        Driver.closeDriver();
    }
}



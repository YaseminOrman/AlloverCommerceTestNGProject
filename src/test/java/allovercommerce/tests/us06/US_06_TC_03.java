package allovercommerce.tests.us06;

import allovercommerce.pages.HomePage06;
import allovercommerce.pages.LoginPage06;
import allovercommerce.pages.ShoppingCart06;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_06_TC_03 {

     /*
   Given  User should land on https://allovercommerce.com/ url
 And Click on 'Sign In' icon
 And Enter a valid user name
 And Enter a valid password
 And Click on 'SIGN IN' button
 And Go to  the  search box
 And Enter  the name of desired product
 And Click the "submit" button
 And Click product link
 And Click Add to Cart Button
 And Click  the card icon
 And Click the view card button
 Check the product that have been added to the cart
 Verify the user  should  see the items that have been added to the cart.
      */

    HomePage06 homePage06 = new HomePage06();
    LoginPage06 loginPage06 =new LoginPage06();
    ShoppingCart06 shoppingCart06 = new ShoppingCart06();
    @Test
    public void TC_03() {
        Driver.getDriver().get(ConfigReader.getProperty("app_homepage_url"));
        homePage06.singInButton.click();
        loginPage06.usernameInput.sendKeys(ConfigReader.getProperty("app_valid_username"));
        loginPage06.passwordInput.sendKeys(ConfigReader.getProperty("app_valid_password"));
        loginPage06.signInButton.click();
        homePage06.signOutButton.click();
        shoppingCart06.searchBox.click();
        shoppingCart06.searchBox.sendKeys("shoes", Keys.ENTER);
        shoppingCart06.submitButton.click();
        shoppingCart06.clickedProductLink.click();
        shoppingCart06.addToCart.click();
        shoppingCart06.cartIcon.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.viewCartIcon.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.cartPage.isDisplayed();

        ReusableMethods.waitFor(2);
        ReusableMethods.verifyElementDisplayed(shoppingCart06.cartPage);

    }
    @AfterMethod
    public void tearDown(){

        Driver.closeDriver();
    }


}


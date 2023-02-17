package allovercommerce.tests.us07;

import allovercommerce.pages.HomePage06;
import allovercommerce.pages.LoginPage06;
import allovercommerce.pages.ShoppingCart06;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_07_TC_03 {
/*
 Given Go to to https://www.allovercommerce.com/compare-2/
 And Click on 'Sign In' icon
 And Enter a valid user name
 And Enter a valid password
 And Click on 'SIGN IN' button
 And  Go to search box
 And Select 4 products.
 And Click on scale icon to compare the products.
 And After selecting products user should be able to click on "start compare" button.
 And The user should be able to remove the products.
 And The user should be able to click on "Go Shop " button
And  User should be able to add new products
 Then  Verify the user is able to compare selected products
   */

    HomePage06 homePage06 = new HomePage06();
    LoginPage06 loginPage06 = new LoginPage06();
    ShoppingCart06 shoppingCart06 = new ShoppingCart06();
    @Test
    public void TC_03() {
        //Go to "https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("app_homepage_url"));
        homePage06.singInButton.click();
        loginPage06.usernameInput.sendKeys(ConfigReader.getProperty("app_valid_username"));
        loginPage06.passwordInput.sendKeys(ConfigReader.getProperty("app_valid_password"));
        loginPage06.signInButton.click();
        homePage06.signOutButton.click();
        shoppingCart06.searchBox.click();
        shoppingCart06.searchBox.sendKeys("Automatic Crusher", Keys.ENTER);
        shoppingCart06.submitButton.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.automaticCrusher.click();
        shoppingCart06.compareIcon.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.backToPage.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.searchBox.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.searchBox.sendKeys("Electric Frying Pan", Keys.ENTER);
        shoppingCart06.submitButton.click();
        shoppingCart06.electricFryingPan.click();
        shoppingCart06.compareIcon.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.backToPage.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.searchBox.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.searchBox.sendKeys("Electric Rice-Cooker", Keys.ENTER);
        shoppingCart06.submitButton.click();
        shoppingCart06.electricRiceCooker.click();
        shoppingCart06.compareIcon.click();
        ReusableMethods.waitFor(2);

        ReusableMethods.waitFor(2);
        shoppingCart06.backToPage.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.searchBox.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.searchBox.sendKeys("Kitchen Cooker", Keys.ENTER);
        shoppingCart06.submitButton.click();
        shoppingCart06.kitchenCooker.click();
        shoppingCart06.compareIcon.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.startCompareButton.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.remove_13229.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.searchBox.sendKeys("Kitchen Table", Keys.ENTER);
        shoppingCart06.submitButton.click();
        shoppingCart06.kitchenTable.click();
        shoppingCart06.compareIcon.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.startCompareButton.click();
        ReusableMethods.waitFor(2);

        for (WebElement w : shoppingCart06.comparePage) {
            ReusableMethods.waitFor(1);
            Assert.assertTrue(w.isDisplayed());


        }
    }

    @AfterMethod
    public void tearDown(){

        Driver.closeDriver();
    }

}


package allovercommerce.tests.us06;

import allovercommerce.pages.HomePage06;
import allovercommerce.pages.LoginPage06;
import allovercommerce.pages.ShoppingCart06;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_06_TC_07 {
    HomePage06 homePage06 =new HomePage06();
    LoginPage06 loginPage06 = new LoginPage06();
    ShoppingCart06 shoppingCart06 = new ShoppingCart06();

    @Test
    public void TC_07() {
        Driver.getDriver().get(ConfigReader.getProperty("app_homepage_url"));
        homePage06.singInButton.click();
        loginPage06.usernameInput.sendKeys(ConfigReader.getProperty("app_valid_username"));
        loginPage06.passwordInput.sendKeys(ConfigReader.getProperty("app_valid_password"));
        loginPage06.signInButton.click();
        homePage06.signOutButton.click();
        ShoppingCart06 shoppingCart06 = new ShoppingCart06();
        shoppingCart06.searchBox.click();
        shoppingCart06.searchBox.sendKeys("shoes", Keys.ENTER);
        shoppingCart06.submitButton.click();
        shoppingCart06.clickedProductLink.click();
        shoppingCart06.addToCart.click();
        shoppingCart06.cartIcon.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.viewCartIcon.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.plusRadioButton.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.minusRadioButton.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.updateToCartButton.click();
        ReusableMethods.waitFor(2);
        // Assert.assertTrue(shoppingCart06.updateToCartButton.isEnabled());
        shoppingCart06.cartIcon.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.checkoutButton.click();
        ReusableMethods.waitFor(2);

        shoppingCart06.firstNameInput.sendKeys("Mary");
        shoppingCart06.lastNameInput.sendKeys("Killer");
        shoppingCart06.companyOptionalName.sendKeys("Magic Lamp");
        ReusableMethods.waitFor(2);
        shoppingCart06.countrySelectDropdown.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.usOption.click();
        ReusableMethods.waitFor(2);
        shoppingCart06.streetAddressInput.sendKeys("7120 Wagon Wheel Rd");
        shoppingCart06.cityNameInput.sendKeys("Fort Worth");
        Select select = new Select(shoppingCart06.stateContainer);
        select.selectByVisibleText("Texas");
        ReusableMethods.waitFor(2);
//        billingDetails.stateNameOption.click();
        shoppingCart06.zipCodeInput.sendKeys("71300");
        shoppingCart06.phoneNumberInput.sendKeys("+1 5092739192");
        shoppingCart06.emailAddressInput.sendKeys("marykiller@gmail.com");
        ReusableMethods.waitFor(2);
        shoppingCart06.paymentMethod.click();
        Assert.assertTrue(shoppingCart06.paymentMethod.isDisplayed());
        ReusableMethods.waitFor(2);
        shoppingCart06.clickPlaceOrder.click();
        Assert.assertTrue(shoppingCart06.clickPlaceOrder.isDisplayed());
        ReusableMethods.waitFor(2);
        for (WebElement w : shoppingCart06.orderCompleteMessage) {
            ReusableMethods.waitFor(1);
            Assert.assertTrue(w.isDisplayed());
            ReusableMethods.waitFor(2);
            shoppingCart06.cartIcon.click();
            shoppingCart06.removeProductFromCart.click();
        }
    }
    @AfterMethod
    public void tearDown(){

        Driver.closeDriver();
    }

}

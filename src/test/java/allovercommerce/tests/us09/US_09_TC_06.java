package allovercommerce.tests.us09;

import allovercommerce.pages.HomePageUS_09;
import allovercommerce.pages.VendorRegistrationPageUS_09;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class US_09_TC_06 {

/*
    US_09 : User should be able to register to the website as Vendor. (Vendor Registration)

    It should be possible to log in using the "Become a Vendor" link on the Sign Up screen.
    User should enter email address.
    "Verification code sent to your email: abc@abc.com." should be visible.
    The code received via email should be entered in the verification code text box.
    Password should be entered and it should contain uppercase, lowercase, digit and special char.
    User should enter password again.
    Registration as a Vendor should be completed by clicking on the Register button.
    The message "This Email already exists. Please login to the site and apply as vendor." should appear if the user tries to register using a registered email address.  */



    VendorRegistrationPageUS_09 vendorRegistrationPageUS_09 = new VendorRegistrationPageUS_09();
    HomePageUS_09 homePageUS_09 = new HomePageUS_09();
    Actions actions = new Actions(Driver.getDriver());



    @Test
    public void test_US_09_TC_06() throws IOException {

        // STEP: Verification code sent to your email: abc@abc.com." should be visible.

        //User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //Click on "Sign In" button
        homePageUS_09.singInButton.click();

        //Click on "Sign up"
        homePageUS_09.singUpButton.click();

        //Click on "Become a Vendor" to navigate Vendor Registration Page
        homePageUS_09.becomeAVendorButton.click();

        //Enter a invalid email address
        vendorRegistrationPageUS_09.registrationEmail.sendKeys(ConfigReader.getProperty("registration_invalid_email"));


        //Verify "Verification code sent to your email:" text is not visible
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        ReusableMethods.waitFor(10);
        Assert.assertFalse(vendorRegistrationPageUS_09.provideValidEmailText.getText().contains("Verification code sent to your email:"));
        ReusableMethods.getScreenshot("test_US_09_TC_05");

        Driver.getDriver().close();
    }


}



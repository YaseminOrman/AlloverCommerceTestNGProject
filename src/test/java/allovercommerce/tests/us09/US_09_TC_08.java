package allovercommerce.tests.us09;

import allovercommerce.pages.HomePageUS_09;
import allovercommerce.pages.VendorRegistrationPageUS_09;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class US_09_TC_08 {

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
    public void test_US_09_TC_08() throws IOException {

        // STEP: The code received via email should be entered in the verification code text box.

        //User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //Click on "Sign In" button
        homePageUS_09.singInButton.click();

        //Click on "Sign up"
        homePageUS_09.singUpButton.click();

        //Click on "Become a Vendor" to navigate Vendor Registration Page
        homePageUS_09.becomeAVendorButton.click();

        //Enter a valid email address
        vendorRegistrationPageUS_09.registrationEmail.sendKeys(ConfigReader.getProperty("registration_valid_email"));

        //Click on Re-Send Code
        vendorRegistrationPageUS_09.reSendCodeButton.click();

        //Enter invalid Re-Send Code in "Verification Code" box.
        String resendCode = ConfigReader.getProperty("re_send_invalid_code");
        vendorRegistrationPageUS_09.reSendCodeInput.sendKeys(resendCode);
        vendorRegistrationPageUS_09.registerButton.click();

        //Verify when user does not enter Re-Send Code "Email Verification Code: This field is required." text is  visible
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Email Verification Code: This field is required."));
        ReusableMethods.getScreenshot("test_US_09_TC_08");

        Driver.getDriver().close();

    }


}



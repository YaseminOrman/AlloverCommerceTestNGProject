package allovercommerce.tests.us10;

import allovercommerce.pages.HomePageUS_09;
import allovercommerce.pages.VendorRegistrationPageUS_09;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class US_10_TC_01 {

    /*
    US_10 : Password level chart should be visible (For Vendor Registration)
    too short
    weak
    good
    strong
     */

    VendorRegistrationPageUS_09 vendorRegistrationPageUS_09 = new VendorRegistrationPageUS_09();
    HomePageUS_09 homePageUS_09 = new HomePageUS_09();
    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void test_US_10_TC_01() throws IOException {

        // STEP: too short

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

        //Enter valid Re-Send Code in "Verification Code" box.
        vendorRegistrationPageUS_09.reSendCodeInput.sendKeys(ConfigReader.getProperty("re_send_valid_code"));

        //Enter a password with less than 6 characters in "Password" text box
        vendorRegistrationPageUS_09.password.sendKeys(ConfigReader.getProperty("tooShort_password"));

        //Verify "Too short"  text is visible
        Assert.assertTrue(vendorRegistrationPageUS_09.passwordStrength.getText().contains("Too short"));
        ReusableMethods.getScreenshot("test_US_10_TC_01");

        Driver.getDriver().close();

    }

}

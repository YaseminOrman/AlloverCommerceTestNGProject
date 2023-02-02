package allover_commerce.tests.US_01;

import allover_commerce.pages.HomePageUS_01;
import allover_commerce.pages.UserRegisterPageUS_01;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_01_TC_03 {
    /*
   Given User should navigate to Allover Commerce url
   When Click on "Register" option
   And Enter valid username
   And Enter valid  email domain
   And Enter  valid password
   And Click "I agree to the privacy policy" box
   And Click on the "SIGN UP" button
   Then Verify user is on the "My Account" page
   */
    HomePageUS_01 homePage = new HomePageUS_01();
    UserRegisterPageUS_01 userRegisterPage = new UserRegisterPageUS_01();
    Faker faker = new Faker();
    @Test
    public void TC_03() {
//    Given User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//    When Click on "Register" option
        homePage.registerButton.click();
//    And Enter invalid username
        userRegisterPage.regUserNameBox.sendKeys(faker.name().username());
//    And Enter an email address
        userRegisterPage.regEmailBox.sendKeys(faker.internet().emailAddress());
//    And Enter  valid password
        userRegisterPage.regPasswordBox.sendKeys(faker.internet().password());
//    And Click "I agree to the privacy policy" box
        userRegisterPage.regPolicyCheckBox.click();
//    And Click on the "SIGN UP" button
        userRegisterPage.regSignUpButton.click();
//    Then verify sign out icon is displayed on the page
        Assert.assertTrue(userRegisterPage.signOutIcon.isDisplayed());
//     And click sign out icon
        userRegisterPage.signOutIcon.click();
//    Then Verify user is on the "My Account" page
        Assert.assertTrue(homePage.myAccountText.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}

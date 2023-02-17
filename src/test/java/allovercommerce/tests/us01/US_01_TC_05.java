package allovercommerce.tests.us01;

import allovercommerce.pages.HomePageUS_01;
import allovercommerce.pages.UserRegisterPageUS_01;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_01_TC_05 {
    /*
    Given User should navigate to Allover Commerce url
    When Click on the 'Register' option
    And Enter valid username
    And Enter valid email domain
    And Check entering weak password(not fallowing password standards"The password should be
        at least twelve characters long. To make it stronger, use upper and lower case letters,
        numbers, and symbols like ! " ? $ % ^ & )."
    And Click "I agree to the privacy policy" box
    And Click on the "SIGN UP" button
    Then Verify user is not able to register an account
     */
    HomePageUS_01 homePage = new HomePageUS_01();
    UserRegisterPageUS_01 userRegisterPage = new UserRegisterPageUS_01();
    Faker faker = new Faker();
    @Test
    public void TC_05(){
//        Given User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        When Click on the 'Register' option
        homePage.registerButton.click();
//        And Enter valid username
        userRegisterPage.regUserNameBox.sendKeys(faker.name().username());
//        And Enter valid email domain
        userRegisterPage.regEmailBox.sendKeys(faker.internet().emailAddress());
//        And Check entering weak password(not fallowing password standards"The password should be
//                at least twelve characters long. To make it stronger, use upper and lower case letters,
//                numbers, and symbols like ! " ? $ % ^ & )."
        userRegisterPage.regPasswordBox.sendKeys("123");
//        And Click "I agree to the privacy policy" box
        userRegisterPage.regPolicyCheckBox.click();
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(userRegisterPage.regSignUpButton);
//        And Click on the "SIGN UP" button
       // userRegisterPage.regSignUpButton.click();
//     Then Verify user is not able to register an account and see Weak - Please enter a stronger password.' warning message
      Assert.assertFalse(userRegisterPage.signOutIcon.isDisplayed());//==>there is a bug in this part

    }
//    @AfterMethod
//    public void tearDown(){
//        Driver.closeDriver();
//    }
}

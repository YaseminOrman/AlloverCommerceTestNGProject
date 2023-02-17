package allovercommerce.tests.us01;

import allovercommerce.pages.HomePageUS_01;
import allovercommerce.pages.UserRegisterPageUS_01;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_01_TC_04 {

    /*
    Given User should navigate to Allover Commerce url
    When Click on the 'Register' option
    And Enter valid username
    And Enter invalid email domain
    And Enter valid password
    And Click "I agree to the privacy policy" box
    And Click on the "SIGN UP" button
    Then Verify user see the incomplete email warning message
     */
    HomePageUS_01 homePage = new HomePageUS_01();
    UserRegisterPageUS_01 userRegisterPage = new UserRegisterPageUS_01();
    Faker faker = new Faker();
    @Test
    public void TC_04(){
//        Given User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        When Click on the 'Register' option
        homePage.registerButton.click();
//        And Enter valid username
        userRegisterPage.regUserNameBox.sendKeys(faker.name().username());
//        And Enter invalid email domain
        userRegisterPage.regEmailBox.sendKeys("johndoe@");
//        And Enter valid password
        userRegisterPage.regPasswordBox.sendKeys(faker.internet().password());
//        And Click "I agree to the privacy policy" box
        userRegisterPage.regPolicyCheckBox.click();
//        And Click on the "SIGN UP" button
        userRegisterPage.regSignUpButton.click();
//        Then Verify user is not able to register an account
        Assert.assertTrue(userRegisterPage.regSignUpButton.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}

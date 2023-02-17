package allovercommerce.tests.us02;

import allovercommerce.pages.HomePageUS_01;
import allovercommerce.pages.UserRegisterPageUS_01;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_02_TC_02 {
    /*
    Given User should navigate to Allover Commerce url
    When Click on "Register" option
    And Enter a valid username
    And Enter previously registered email address
    And Enter  a valid password
    And Click "I agree to the privacy policy" box
    And Click on the "SIGN UP" button
    Then Verify user see 'An account is already registered with your email address. Please log in.' warning message
     */
    @DataProvider
    public Object[][] userData(){
        //  TEST DATA
        Object [][] userCredential = {{"johndoe44@gmail.com"}};

        return userCredential;
    }
    @Test(dataProvider ="userData" )
    public void TC_02(String email){
        HomePageUS_01 homePageUS_01 = new HomePageUS_01();
        UserRegisterPageUS_01 userRegisterPage = new UserRegisterPageUS_01();
        Faker faker = new Faker();
//        Given User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        When Click on "Register" option
        homePageUS_01.registerButton.click();
//        And Enter a valid username
        userRegisterPage.regUserNameBox.sendKeys(faker.name().username());
//        And Enter previously registered email address
        userRegisterPage.regEmailBox.sendKeys(email);
//        And Enter  a valid password
        userRegisterPage.regPasswordBox.sendKeys(faker.internet().password());
//        And Click "I agree to the privacy policy" box
        userRegisterPage.regPolicyCheckBox.click();
//        And Click on the "SIGN UP" button
        userRegisterPage.regSignUpButton.click();
//        Then Verify user see 'An account is already registered with your email address. Please log in.' warning message
        Assert.assertTrue(userRegisterPage.emailWarningText.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}

package allover_commerce.tests.US_02;

import allover_commerce.pages.HomePageUS_01;
import allover_commerce.pages.UserRegisterPageUS_01;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_02_TC_03 {
    /*
    Given User should navigate to Allover Commerce url
    When Click on "Register" option
    And Enter previously registered username
    And Enter previously registered email address
    And Enter  previously registered password
    And Click "I agree to the privacy policy" box
    And Click on the "SIGN UP" button
    Then Verify user see 'An account is already registered with your email address. Please log in.' warning message
     */
    @DataProvider
    public Object[][] userData(){
        //  TEST DATA
        Object [][] userCredentials = {{"JohnDoe44","johndoe44@gmail.com","helloworld-447"}};

        return userCredentials;
    }
    @Test(dataProvider ="userData" )
    public void TC_02(String username,String email,String password){
        HomePageUS_01 homePageUS_01 = new HomePageUS_01();
        UserRegisterPageUS_01 userRegisterPage = new UserRegisterPageUS_01();
        Faker faker = new Faker();
//        Given User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        When Click on "Register" option
        homePageUS_01.registerButton.click();
//        And Enter a valid username
        userRegisterPage.regUserNameBox.sendKeys(username);
//        And Enter previously registered email address
        userRegisterPage.regEmailBox.sendKeys(email);
//        And Enter  a valid password
        userRegisterPage.regPasswordBox.sendKeys(password);
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

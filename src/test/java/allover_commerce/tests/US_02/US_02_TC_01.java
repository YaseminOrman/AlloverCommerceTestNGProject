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

public class US_02_TC_01 {
    /*
    Given User should navigate to Allover Commerce url
    When Click on "Register" option
    And Enter previously registered username
    And Enter a valid email address
    And Enter  a valid password
    And Click "I agree to the privacy policy" box
    And Click on the "SIGN UP" button
    Then "Verify user see 'An account is already registered with that username. Please choose another.' warning message"
     */
    @DataProvider
    public Object[][] userData(){
        //  TEST DATA
        Object [][] userCredential = {{"JohnDoe44"}};

        return userCredential;
    }

    @Test(dataProvider = "userData")
    public void TC_01(String userName){
//        User should navigate to Allover Commerce url
        HomePageUS_01 homePageUS_01 = new HomePageUS_01();
        UserRegisterPageUS_01 userRegisterPage = new UserRegisterPageUS_01();
        Faker faker = new Faker();
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        Click on "Register" option
        homePageUS_01.registerButton.click();
//        Enter previously registered username
        userRegisterPage.regUserNameBox.sendKeys(userName);
//        Enter a valid email address
        userRegisterPage.regEmailBox.sendKeys(faker.internet().emailAddress());
//        Enter  a valid password
        userRegisterPage.regPasswordBox.sendKeys(faker.internet().password());
//        Click "I agree to the privacy policy" box
        userRegisterPage.regPolicyCheckBox.click();
//        Click on the "SIGN UP" button
        userRegisterPage.regSignUpButton.click();
//        "Verify user see 'An account is already registered with that username. Please choose another.' warning message"
        Assert.assertTrue(userRegisterPage.userNameWarningText.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}

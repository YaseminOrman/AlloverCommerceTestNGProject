package allover_commerce.tests.US_02;

import allover_commerce.pages.HomePageUS_01;
import allover_commerce.pages.UserRegisterPageUS_01;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_02_TC_04 {

    /*
    Given User should navigate to Allover Commerce url
    When Click on "Register" option
    And Enter previously registered username
    And Enter previously registered email address
    And Enter  invalid(weak) password
    And Click "I agree to the privacy policy" box
    Then Verify  user see 'Weak - Please enter a stronger password.' warning message
     */
    @DataProvider
    public Object[][] userData(){
        //  TEST DATA
        Object [][] userCredentials = {{"JohnDoe44","johndoe44@gmail.com"}};

        return userCredentials;
    }
    @Test(dataProvider ="userData" )
    public void TC_02(String username,String email){
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
        ReusableMethods.waitFor(3);
        userRegisterPage.regPasswordBox.sendKeys("");
        ReusableMethods.waitFor(3);
//        And Click "I agree to the privacy policy" box
        userRegisterPage.regPolicyCheckBox.click();
        ReusableMethods.waitFor(3);
//        Then Verify  user see 'Weak - Please enter a stronger password.' warning message
        Assert.assertTrue(userRegisterPage.weakPasswordWarningText.getText().contains("Weak - Please enter a stronger password."));
    }
//    @AfterMethod
//    public void tearDown(){
//        Driver.closeDriver();
//    }


}


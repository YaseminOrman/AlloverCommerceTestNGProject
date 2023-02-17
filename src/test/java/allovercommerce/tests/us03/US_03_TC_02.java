package allovercommerce.tests.us03;

import allovercommerce.pages.HomePageUS_01;
import allovercommerce.pages.LoginPageUS_01;
import allovercommerce.pages.MyAccountPageUS_01;
import allovercommerce.pages.UserRegisterPageUS_01;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_03_TC_02 {
    /*
    Given User should navigate to Allover Commerce url
    When Click on 'Sign In' option
    And Enter valid  username and password
    And Click on 'SIGN IN' button
    And Click on User Icon button
    And Click 'Addresses' option on My Account page
    And Click 'ADD' option under Billing Address
    Then Verify the registered email address is displayed on the page
     */
    @DataProvider
    public Object[][] userData(){
        Object[][] userCredentials = {{"john3113@gmail.com","nevergiveup1331"}};
        return userCredentials;
    }
    @Test(dataProvider = "userData")
    public void TC_02(String email ,String password){
        HomePageUS_01 homePageUS_01 = new HomePageUS_01();
        UserRegisterPageUS_01 userRegisterPage = new UserRegisterPageUS_01();
        MyAccountPageUS_01 myAccountPageUS_01 = new MyAccountPageUS_01();
        LoginPageUS_01 loginPageUS01 =new LoginPageUS_01();
//        Given User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        When Click on 'Sign In' option
        homePageUS_01.signInOption.click();
//        And Enter valid  username and password
        loginPageUS01.usernameInput.sendKeys(email);
        loginPageUS01.passwordInput.sendKeys(password);
//        And Click on 'SIGN IN' button
        loginPageUS01.signInButton.click();
        ReusableMethods.waitFor(3);
//        And Click on User Icon button
        homePageUS_01.userIconButton.click();
//        And Click 'Addresses' option on My Account page
        myAccountPageUS_01.addressLink.click();
//        And Click 'ADD' option under Billing Address
        myAccountPageUS_01.addAddressLink.click();
        ReusableMethods.waitFor(3);
//        Then Verify the registered email address is displayed on the page
        Assert.assertEquals(JSUtils.getValueInStringByJS("billing_email"),email);
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}

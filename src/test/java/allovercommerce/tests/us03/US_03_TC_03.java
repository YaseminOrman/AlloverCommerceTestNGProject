package allovercommerce.tests.us03;

import allovercommerce.pages.HomePageUS_01;
import allovercommerce.pages.LoginPageUS_01;
import allovercommerce.pages.MyAccountPageUS_01;
import allovercommerce.pages.UserRegisterPageUS_01;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_03_TC_03 {
    /*
    Given User should navigate to Allover Commerce url
    When Click on 'Sign In' option
    And Enter valid  username and password
    And Click on 'SIGN IN' button
    And Click on User Icon button
    And Click 'Addresses' option on My Account page
    And Click 'ADD' option under Billing Address
    And Enter Billing Address details into the Mandatory Fields (Firstname,Lastname,Country/Region,Street address,Town/City,State,zipcode
    And Enter phone number into Phone field
    And Click 'SAVE ADDRESS' button
    Then Verify user see 'PHONE is not a valid phone number.' warning message"
     */
    @DataProvider
    public Object[][] userData(){
        Object[][] userCredentials = {{"John","Doe","7777 Hickory St","Austin","78610","512***ab**"}};
        return userCredentials;
    }
    @Test(dataProvider = "userData")
    public void TC_03(String firstname,String lastname,String stAddress,String city,String zipcode,String phone){
        HomePageUS_01 homePageUS_01 = new HomePageUS_01();
        UserRegisterPageUS_01 userRegisterPage = new UserRegisterPageUS_01();
        MyAccountPageUS_01 myAccountPageUS_01 = new MyAccountPageUS_01();
        LoginPageUS_01 loginPageUS01 =new LoginPageUS_01();
//        Given User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        When Click on 'Sign In' option
        homePageUS_01.signInOption.click();
//        And Enter valid  username and password
        loginPageUS01.usernameInput.sendKeys(ConfigReader.getProperty("valid_email"));
        loginPageUS01.passwordInput.sendKeys(ConfigReader.getProperty("valid_password"));
//        And Click on 'SIGN IN' button
        loginPageUS01.signInButton.click();
        ReusableMethods.waitFor(3);
//        And Click on User Icon button
        homePageUS_01.userIconButton.click();
//        And Click 'Addresses' option on My Account page
        myAccountPageUS_01.addressLink.click();
//        And Click 'ADD' option under Billing Address
        myAccountPageUS_01.addAddressLink.click();
        ReusableMethods.waitFor(2);
//        And Enter Billing Address details into the Mandatory Fields (Firstname,Lastname,Country/Region,Street address,Town/City,State,zipcode
//        And Enter phone number into Phone field
        myAccountPageUS_01.firstnameInput.sendKeys(firstname);
        myAccountPageUS_01.lastnameInput.sendKeys(lastname);
        JSUtils.scrollIntoViewJS(myAccountPageUS_01.countryDropdown);
        ReusableMethods.waitFor(2);
        myAccountPageUS_01.countryDropdown.click();
        ReusableMethods.waitFor(3);
        myAccountPageUS_01.usOption.click();
//        Select selectCountry=new Select(myAccountPageUS_01.countryDropdown);
//        selectCountry.selectByVisibleText("United States (US)");
        ReusableMethods.waitFor(2);
        myAccountPageUS_01.StAddress.sendKeys(stAddress);
        ReusableMethods.waitFor(2);
        myAccountPageUS_01.cityInput.sendKeys(city);
        ReusableMethods.waitFor(2);
        Select selectState=new Select(myAccountPageUS_01.stateDropdown);
        selectState.selectByVisibleText("Texas");
        ReusableMethods.waitFor(2);
        myAccountPageUS_01.zipcodeInput.sendKeys(zipcode);
        myAccountPageUS_01.phoneInput.sendKeys(phone);
//        And Click 'SAVE ADDRESS' button
        JSUtils.scrollIntoViewJS(myAccountPageUS_01.saveAddressButton);
        ReusableMethods.waitFor(2);
        myAccountPageUS_01.saveAddressButton.click();
//        Then Verify user see 'PHONE is not a valid phone number.' warning message"
        Assert.assertTrue(myAccountPageUS_01.phoneWarningMessage.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}

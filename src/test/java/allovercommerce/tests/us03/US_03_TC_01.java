package allovercommerce.tests.us03;

import allovercommerce.pages.HomePageUS_01;
import allovercommerce.pages.MyAccountPageUS_01;
import allovercommerce.pages.UserRegisterPageUS_01;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_03_TC_01 {
    /*

    Given User should navigate to Allover Commerce url
    When Click on the 'Register' option
    And Enter valid username
    And Enter valid email address
    And Enter valid password
    And Click on "I agree to the privacy policy"checkbox
    And Click on the "SIGN UP" button
    And Click on user icon button
    Then Verify user is on the 'My Account' page
    And Click 'Addresses' option on My Account page
    And Click 'ADD' option under Billing Address
    And Enter Billing Address details into the Mandatory Fields (Firstname,Lastname,Country/Region,Street address,Town/City,State,zipcode,Phone
    And Click 'SAVE ADDRESS' button
    Then Verify billing address is added and is displayed on 'My Account'page
     */
    @DataProvider
    public Object[][] userData(){
        Object[][] userCredentials = {{"John","Doe","7777 Hickory St","Austin","78610","5125556677"}};
        return userCredentials;
    }
    @Test(dataProvider ="userData" )
    public void TC_01(String firstname,String lastname,String stAddress,String city,String zipcode,String phone){
        HomePageUS_01 homePageUS_01 = new HomePageUS_01();
        UserRegisterPageUS_01 userRegisterPage = new UserRegisterPageUS_01();
        MyAccountPageUS_01 myAccountPageUS_01 = new MyAccountPageUS_01();
        Faker faker = new Faker();
//        Given User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        When Click on the 'Register' option
        homePageUS_01.registerButton.click();
//        And Enter valid username
        userRegisterPage.regUserNameBox.sendKeys(faker.name().username());
//        And Enter valid email address
        userRegisterPage.regEmailBox.sendKeys(faker.internet().emailAddress());
//        And Enter valid password
        userRegisterPage.regPasswordBox.sendKeys(faker.internet().password());
//        And Click on "I agree to the privacy policy"checkbox
        userRegisterPage.regPolicyCheckBox.click();
//        And Click on the "SIGN UP" button
        userRegisterPage.regSignUpButton.click();
//        And Click on user icon button
        ReusableMethods.waitFor(3);
        homePageUS_01.userIconButton.click();
//        Then Verify user is on the 'My Account' page
        Assert.assertTrue(homePageUS_01.myAccountText.isDisplayed());
//        And Click 'Addresses' option on My Account page
        myAccountPageUS_01.addressLink.click();
//        And Click 'ADD' option under Billing Address
        myAccountPageUS_01.addAddressLink.click();
//        And Enter Billing Address details into the Mandatory Fields (Firstname,Lastname,Country/Region,Street address,Town/City,State,zipcode,Phone
        myAccountPageUS_01.firstnameInput.sendKeys(firstname);
        myAccountPageUS_01.lastnameInput.sendKeys(lastname);
        ReusableMethods.waitFor(2);
        myAccountPageUS_01.countryDropdown.click();
        ReusableMethods.waitFor(2);
        myAccountPageUS_01.usOption.click();
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
//        Then Verify billing address is added and is displayed on 'My Account'page
        Assert.assertTrue(myAccountPageUS_01.editAddressLink.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}

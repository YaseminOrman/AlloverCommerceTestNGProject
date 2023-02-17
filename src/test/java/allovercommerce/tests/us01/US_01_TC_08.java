package allovercommerce.tests.us01;

import allovercommerce.pages.HomePageUS_01;
import allovercommerce.pages.UserRegisterPageUS_01;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_01_TC_08 {
   /*
    Given User should navigate to Allover Commerce url
    When Click on the 'Register' option
    And Enter valid username by using  Keyboard Keys(TAB,Spacebar or Enter)
    And Enter valid email address by using  Keyboard Keys(TAB,Spacebar or Enter)
    And Enter valid password by using  Keyboard Keys(TAB,Spacebar or Enter)
    And Click "I agree to the privacy policy" box by using  Keyboard Keys(TAB,Spacebar or Enter)
    And Click on the "SIGN UP" button
    And Click Sign Out option
    Then Verify user on the "My Account"page
    */
    HomePageUS_01 homePageUS_01 = new HomePageUS_01();
    UserRegisterPageUS_01 userRegisterPage = new UserRegisterPageUS_01();
    Faker faker = new Faker();
    @Test
    public void TC_08(){
//        User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        Click on the 'Register' option
       homePageUS_01.registerButton.click();
//        Enter valid username by using  Keyboard Keys(TAB,Space-bar or Enter)
       userRegisterPage.regUserNameBox.sendKeys(faker.name().username(),Keys.TAB);
//        Enter valid email address by using  Keyboard Keys(TAB,Space-bar or Enter)
        userRegisterPage.regEmailBox.sendKeys(faker.internet().emailAddress(),Keys.TAB);
//        Enter valid password by using  Keyboard Keys(TAB,Space-bar or Enter)
        userRegisterPage.regPasswordBox.sendKeys(faker.internet().password());
//        Click "I agree to the privacy policy" box by using  Keyboard Keys(TAB,Space-bar or Enter)
        userRegisterPage.regPolicyCheckBox.sendKeys(Keys.SPACE);
//        Click on the "SIGN UP" button
        userRegisterPage.regSignUpButton.sendKeys(Keys.ENTER);
//        Click Sign Out option
        userRegisterPage.signOutIcon.click();
//        Verify user on the "My Account"page
        Assert.assertTrue(homePageUS_01.myAccountText.isDisplayed());


    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}

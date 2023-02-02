package allover_commerce.tests.US_01;

import allover_commerce.pages.HomePageUS_01;
import allover_commerce.pages.UserRegisterPageUS_01;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_01_TC_02 {
    /*
    Given User should navigate to Allover Commerce url
    When Click on "Register" option
    And Enter invalid username
    And Enter an email address
    And Enter  valid password
    And Click "I agree to the privacy policy" box
    And Click on the "SIGN UP" button
    Then Verify user see the "Please enter a valid account username."notification message
    */
    HomePageUS_01 homePage = new HomePageUS_01();
    UserRegisterPageUS_01 userRegisterPage = new UserRegisterPageUS_01();
    Faker faker = new Faker();
    @Test
    public void TC_02() {
//    Given User should navigate to Allover Commerce url
       Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//    When Click on "Register" option
        homePage.registerButton.click();
//    And Enter invalid username
        userRegisterPage.regUserNameBox.sendKeys("abc***");
//    And Enter an email address
        userRegisterPage.regEmailBox.sendKeys(faker.internet().emailAddress());
//    And Enter  valid password
        userRegisterPage.regPasswordBox.sendKeys(faker.internet().password());
//    And Click "I agree to the privacy policy" box
        userRegisterPage.regPolicyCheckBox.click();
//    And Click on the "SIGN UP" button
        userRegisterPage.regSignUpButton.click();
//    Then Verify user see the "Please enter a valid account username."notification message
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//p[text()='Please enter a valid account username.']")).isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}

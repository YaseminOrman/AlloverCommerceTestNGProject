package allovercommerce.tests.US_19;

import allovercommerce.pages.*;
import allovercommerce.utilities.JSUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_19_TC_03 {

    US_19_TC_02 us_19_tc_02 = new US_19_TC_02();
    HomePageUS19_20 homePage = new HomePageUS19_20();
    LoginPageUS19_20 loginPage = new LoginPageUS19_20();
    VendorMyAccountPageUS19_20 vendorMyAccountPage = new VendorMyAccountPageUS19_20();
    VendorShoppingPageUS19_20 vendorShoppingPage = new VendorShoppingPageUS19_20();
    VendorCheckOutPageUS19_20 vendorCheckOutPage = new VendorCheckOutPageUS19_20();
    Faker faker = new Faker();

    @Test
    public void fillBillingDetailsTest() {
       us_19_tc_02.vendorLogin();
       us_19_tc_02.addMacBookIntoCart();

       // fill out firstname box
        vendorCheckOutPage.billing_first_name.clear();
        vendorCheckOutPage.billing_first_name.sendKeys(faker.name().firstName());

//        fill out lastname box
        vendorCheckOutPage.billing_last_name.clear();
        vendorCheckOutPage.billing_last_name.sendKeys(faker.name().lastName());

//        fill out company box
        vendorCheckOutPage.billing_company.clear();
        vendorCheckOutPage.billing_company.sendKeys(faker.company().name());

//        select country
        Select select = new Select(vendorCheckOutPage.billing_country);
        select.selectByVisibleText("Canada");

//        fill out street address box
        vendorCheckOutPage.billing_street_address.clear();
        vendorCheckOutPage.billing_street_address.sendKeys(faker.address().streetAddress());

//       fill out address box2
        vendorCheckOutPage.billing_address2.clear();
        vendorCheckOutPage.billing_address2.sendKeys(faker.address().buildingNumber());

//       fill out city box
        vendorCheckOutPage.billing_city.clear();
        vendorCheckOutPage.billing_city.sendKeys(faker.address().cityName());

//       select province
        Select select1 = new Select(vendorCheckOutPage.billing_state);
        select1.selectByVisibleText("Ontario");

//        fill out postal code box
        vendorCheckOutPage.billing_postcode.clear();
        vendorCheckOutPage.billing_postcode.sendKeys(faker.address().zipCode());

//        fill out phone number box
        vendorCheckOutPage.billing_phone.clear();
        vendorCheckOutPage.billing_phone.sendKeys(faker.phoneNumber().cellPhone());

//        verify email is "sasusa.odupog@gotgel.org"
        String actualEmail = JSUtils.getValueInStringByJS("billing_email");
        String expectedEmail = "sasusa.odupog@gotgel.org";
        Assert.assertEquals(actualEmail,expectedEmail);

    }
}

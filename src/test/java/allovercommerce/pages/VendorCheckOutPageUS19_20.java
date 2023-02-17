package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorCheckOutPageUS19_20 {
    public VendorCheckOutPageUS19_20() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //*******************FUNDA US_19, US_20 *******************
    @FindBy(id = "billing_first_name")
    public WebElement billing_first_name;

    @FindBy(id = "billing_last_name")
    public WebElement billing_last_name;

    @FindBy(id = "billing_company")
    public WebElement billing_company;

    @FindBy(xpath = "//select[@id='billing_country']")
    public WebElement billing_country;

    @FindBy(xpath = "//input[@id='billing_address_1']")
    public WebElement billing_street_address;

    @FindBy(xpath = "//input[@id='billing_address_2']")
    public WebElement billing_address2;

    @FindBy(xpath = "//input[@id='billing_city']")
    public WebElement billing_city;

    @FindBy(xpath = "//select[@id='billing_state']")
    public WebElement billing_state;

    @FindBy(xpath = "//input[@id='billing_postcode']")
    public WebElement billing_postcode;

    @FindBy(id = "billing_phone")
    public WebElement billing_phone;

    @FindBy(xpath = "//input[@id='billing_email']")
    public WebElement billing_email;

    @FindBy(xpath = "(//th[text()='Subtotal'])[2]")
    public WebElement subtotal;

    @FindBy(id = "payment_method_bacs")
    public WebElement wireTransfer;

    @FindBy(id = "payment_method_cod")
    public WebElement payAtTheDoor;


}

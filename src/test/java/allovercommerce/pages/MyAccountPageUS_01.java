package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPageUS_01 {
    public MyAccountPageUS_01(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Addresses")
    public WebElement addressLink;

    @FindBy(xpath = "(//a[@class='edit btn btn-link btn-primary btn-underline mb-4'])[1]")
    public WebElement addAddressLink;

    @FindBy(id = "billing_first_name")
    public WebElement firstnameInput;

    @FindBy(id = "billing_last_name")
    public WebElement lastnameInput;

    @FindBy(id="select2-billing_country-container")
    public WebElement countryDropdown;

    @FindBy(xpath = "//li[contains(text(),'United States (US)')][1]")
    public WebElement usOption;

    @FindBy(id = "billing_address_1")
    public WebElement StAddress;

    @FindBy(id = "billing_city")
    public WebElement cityInput;

    @FindBy(id ="billing_state")
    public WebElement stateDropdown;

    //    @FindBy(xpath ="//li[contains(text(),'Texas')]")
//    public WebElement stateNameOption;
    @FindBy(id = "billing_postcode")
    public WebElement zipcodeInput;

    @FindBy(id = "billing_phone")
    public WebElement phoneInput;

    @FindBy(xpath = "//button[@name='save_address']")
    public WebElement saveAddressButton;

    @FindBy(xpath = "//a[text()='Edit Your Billing Address']")
    public WebElement editAddressLink;

    @FindBy(id = "billing_email")
    public WebElement emailBox;

    @FindBy(xpath = "//li[@class=' alert alert-simple alert-icon alert-close-top alert-danger']")
    public WebElement phoneWarningMessage;

//    @FindBy(linkText = "Edit Your Billing Address")
//    public WebElement editAddressLink;


}

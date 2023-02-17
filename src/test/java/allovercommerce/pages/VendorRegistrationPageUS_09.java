package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorRegistrationPageUS_09 {

    public VendorRegistrationPageUS_09(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

//----------Vendor Registration with Sign Up------------------------------------------------------------------
    @FindBy(id = "user_email")
    public WebElement registrationEmail;

    @FindBy(xpath= "//*[.='Email: This field is required.']")
    public WebElement emailIsRequiredText;

    @FindBy(xpath= "//div[@class='wcfm-message email_verification_message wcfm-success']")
    public WebElement verificationCodeText;

    @FindBy(xpath= "//*[.='Please provide a valid email address.']")
    public WebElement provideValidEmailText;

    @FindBy(xpath = "//input[@name='wcfm_email_verified_button']")
    public WebElement reSendCodeButton;

    @FindBy(xpath = "//input[@name='wcfm_email_verified_input']")
    public WebElement reSendCodeInput;

    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement codeInvalidText;

    @FindBy(id = "passoword")
    public WebElement password;

    @FindBy(id = "confirm_pwd")
    public WebElement confirmPassword;

    @FindBy(id = "password_strength")
    public WebElement passwordStrength;

    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[contains(text(), 'Password strength should be atleast')]")
    public WebElement passwordRules;


    @FindBy(id = "wcfm_membership_register_button")
    public WebElement registerButton;


    @FindBy(xpath = "//h1[.='Welcome to Allover Commerce!']")
    public WebElement welcomeMessage;

    @FindBy(xpath = "//*[.='Email verification code invalid.']")
    public WebElement codeInvalidMessage;

    @FindBy(xpath = "//*[.='This Email already exists. Please login to the site and apply as vendor.']")
    public WebElement alreadyExistMessage;

    @FindBy(xpath = "//div[@class='wcfm-message wcfm-success']")
    public WebElement registrationSuccessMessage;


//----------Vendor Registration with Sign In------------------------------------------------------------------

    @FindBy(id = "username")
    public WebElement existVendorUsername;

    @FindBy(id = "password")
    public WebElement existVendorPassword;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement existVendorSignInButton;




}

package allover_commerce.pages;

import allover_commerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRegisterPageUS_01 {

     public UserRegisterPageUS_01(){
         PageFactory.initElements(Driver.getDriver(),this);
     }
    //********************YASEMIN**************************

    @FindBy(xpath = "//input[@id='reg_username']")
    public WebElement regUserNameBox;

    @FindBy(xpath = "//input[@id='reg_email']")
    public WebElement regEmailBox;

    @FindBy(xpath = "//input[@id='reg_password']")
    public WebElement regPasswordBox;

    @FindBy(id = "register-policy")
    public WebElement regPolicyCheckBox;

    @FindBy(xpath = "//button[@name='register']")
    public WebElement regSignUpButton;

    @FindBy(linkText = "Sign Out")
    public WebElement signOutIcon;

    @FindBy(xpath = "//div[@class='woocommerce-privacy-policy-text']")
    public WebElement emptyPasswordWarningText;

    @FindBy(linkText = "Sign Up")
    public WebElement signUpLink;

    @FindBy(xpath = "//p[text()='An account is already registered with that username. Please choose another.']")
    public WebElement userNameWarningText;

    @FindBy(xpath = "//p[text()='An account is already registered with your email address. ']")
    public WebElement emailWarningText;

    @FindBy(xpath = "//div[@aria-live='polite']")
    public WebElement weakPasswordWarningText;

}

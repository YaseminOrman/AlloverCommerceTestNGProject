package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageUS_09 {

    public HomePageUS_09(){
        PageFactory.initElements(Driver.getDriver(), this);
    }





//--------------for US_09, US_10, US_11 ------------------------------------
    @FindBy(xpath = "//a[@href='signup']")
    public WebElement singUpButton;

    @FindBy(xpath = "//a[.='Become a Vendor']")
    public WebElement becomeAVendorButton;

    @FindBy(xpath = "//h2[.='Vendor Registration']")
    public WebElement VendorRegistrationText;

    @FindBy(xpath = "//h3[.='MY ACCOUNT']")
    public WebElement myAccountText;

    @FindBy(xpath = "//*[.='Wrong username or password.']")
    public WebElement wrongUsernameOrPassword;

    @FindBy(xpath = "//*[.='Sign Out']")
    public WebElement signOut;









//*******************HATICE US_12, US_13, US_14*******************
    @FindBy(linkText = "Sign In")
    public WebElement singInButton;


    @FindBy(linkText = "Sign Out")
    public WebElement signOutButton;

//******************END*********************************************





}

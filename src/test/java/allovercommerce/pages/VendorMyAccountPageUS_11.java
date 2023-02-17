package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorMyAccountPageUS_11 {

    public VendorMyAccountPageUS_11(){
        PageFactory.initElements(Driver.getDriver(), this);

    }


    //----------------for US_11-------------------------------
    @FindBy(xpath = "//h2[.='My Account']")
    public WebElement myAccountText;

    @FindBy(linkText = "ORDERS")
    public WebElement ordersIcon;

    @FindBy(linkText = "DOWNLOADS")
    public WebElement downloadsIcon;

    @FindBy(linkText = "ADDRESSES")
    public WebElement addressesIcon;

    @FindBy(linkText = "ACCOUNT DETAILS")
    public WebElement accountDetailsIcon;

    @FindBy(linkText = "WISHLIST")
    public WebElement wishListIcon;

    @FindBy(linkText = "LOGOUT")
    public WebElement logoutIcon;



//---for left menu--------------------

    @FindBy(linkText = "Store Manager")
    public WebElement storeManagerIcon;

    @FindBy(linkText = "Orders")
    public WebElement ordersLeft;

    @FindBy(linkText = "Downloads")
    public WebElement downloadsLeft;

    @FindBy(linkText = "Addresses")
    public WebElement addressesLeft;

    @FindBy(linkText = "Account details")
    public WebElement accountDetailsLeft;

    @FindBy(linkText = "Wishlist")
    public WebElement wishlistLeft;

    @FindBy(linkText = "Support Tickets")
    public WebElement supportTickets;

    @FindBy(linkText = "Followings")
    public WebElement followings;

    @FindBy(linkText = "Logout")
    public WebElement logoutLeft;


    @FindBy(xpath = "//a[@href='https://allovercommerce.com/my-account-2/edit-address/shipping/']")
    public WebElement editYourShippingAdress;


    @FindBy(xpath = "//button[@value='Save address']")
    public WebElement saveAdress;

    @FindBy(xpath = "//div[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement successMessage;










}

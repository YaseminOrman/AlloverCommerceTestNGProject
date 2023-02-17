package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorShoppingPageUS19_20 {
    public VendorShoppingPageUS19_20() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    //*******************FUNDA US_19, US_20 *******************
    @FindBy(linkText = "16 ” MacBook Pro")
    public WebElement macbookLink;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    public WebElement macBookAddToCart;

    @FindBy(xpath = "(//i[@class='w-icon-cart'])[1]")
    public WebElement cart;

    @FindBy(xpath = "(//span[text()='16 \" MacBook Pro'])[2]")
    public WebElement macbook16InCart;

    @FindBy(xpath = "//a[text()='Checkout']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//h3[text()='Billing details']")
    public WebElement billingDetailsText;

}

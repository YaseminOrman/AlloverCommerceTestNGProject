package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreManagerPageUS19_20 {
    public StoreManagerPageUS19_20() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//span[@class='text'])[6]")
    public WebElement coupons;

    @FindBy(xpath = "//h2[text()='Coupons Listing']")
    public WebElement couponsListing;

    @FindBy(xpath = "//span[text()='Add New']")
    public WebElement addNewCouponButton;

    @FindBy(xpath = "//h2[text()='Add Coupon']")
    public WebElement addCouponText;

    @FindBy(id = "title")
    public WebElement code;

    @FindBy(id = "description")
    public WebElement description;

    @FindBy(id = "discount_type")
    public WebElement discount_type;

    @FindBy(id = "coupon_amount")
    public WebElement couponAmount;

    @FindBy(id = "expiry_date")
    public WebElement expiry_date;

    @FindBy(id = "free_shipping")
    public WebElement free_shipping;

    @FindBy(id = "show_on_store")
    public WebElement show_on_store;

    @FindBy(xpath = "//input[@value='Submit']")
    public WebElement couponSubmitButton;

    @FindBy(xpath = "//h2[text()='Edit Coupon']")
    public WebElement editCoupon;


}

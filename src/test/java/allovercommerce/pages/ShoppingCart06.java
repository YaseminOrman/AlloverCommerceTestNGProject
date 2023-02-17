package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCart06 {
    public ShoppingCart06() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@id='product-13211']/div[2]/div/h1")
    public WebElement selectedDesiredProduct;

    @FindBy(xpath = "//a[contains(text(),'Gray Leather Shoes')]")
    public WebElement clickedProductLink;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    public WebElement addToCart;

    @FindBy(xpath = "//*[@class='remove remove_from_cart_button']")
    public WebElement removeProductFromCart;

    @FindBy(xpath ="//*[@id='main']/div/div/div/div[1]/div")
    public WebElement successVerification;

    @FindBy(xpath ="//i[@class='w-icon-cart']")
    public WebElement cartIcon;

    @FindBy(xpath ="//a[contains(text(),'View cart')]")
    public WebElement viewCartIcon;

    @FindBy(xpath ="//*[@id='main']/div")
    public WebElement cartPage;


    @FindBy(xpath ="//button[@class='quantity-minus w-icon-minus']")
    public WebElement minusRadioButton;

    @FindBy(xpath = "//button[@class='quantity-plus w-icon-plus']")
    public WebElement plusRadioButton;

    @FindBy(xpath =" //button[@value='Update cart']")
    public WebElement updateToCartButton;


    @FindBy(xpath ="//*[@class='button checkout wc-forward']")
    public WebElement checkoutButton;


    @FindBy(xpath ="//*[@id='billing_first_name'] ")
    public WebElement firstNameInput;


    @FindBy(xpath ="//*[@id='billing_last_name'] ")
    public WebElement lastNameInput;

    @FindBy(id="billing_company")
    public WebElement companyOptionalName;


    @FindBy(id="select2-billing_country-container")
    public WebElement countrySelectDropdown;

    @FindBy(xpath = "//li[contains(text(),'United States (US)')][1]")
    public WebElement usOption;

    @FindBy(xpath ="//*[@id='billing_address_1']")
    public WebElement streetAddressInput;

    @FindBy(xpath ="//*[@id='billing_city']")
    public WebElement cityNameInput;

    @FindBy(id ="billing_state")
    public WebElement stateContainer;

    @FindBy(xpath ="//li[contains(text(),'Texas')]")
    public WebElement stateNameOption;


    @FindBy(xpath ="//*[@id='billing_postcode']")
    public WebElement zipCodeInput;

    @FindBy(xpath ="//*[@id='billing_phone']")
    public WebElement phoneNumberInput;


    @FindBy(xpath ="//*[@id='billing_email']")
    public WebElement emailAddressInput;

    @FindBy(xpath ="//h1")
    public WebElement productTitle;


    @FindBy(xpath = "//div[@class='woocommerce-billing-fields__field-wrapper row gutter-sm']/p")
    public List<WebElement> billingInfoTableElement;

    @FindBy(xpath ="//*[@id='payment']/ul/li[1]/label")
    public WebElement paymentMethod;

    @FindBy(xpath ="//*[@class='woocommerce-checkout-review-order']")
    public List<WebElement >clickedPaymentMethod;



    @FindBy(xpath ="//button[@name='woocommerce_checkout_place_order']")
    public WebElement clickPlaceOrder;


    @FindBy(xpath = "//*[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public List<WebElement> orderCompleteMessage;


    @FindBy(xpath ="//*[@id='product-13229']/div[2]/div/h1")
    public WebElement automaticCrusher;

    @FindBy(xpath ="//*[@class='compare btn-product-icon']")
    public WebElement compareIcon;

    @FindBy(xpath ="//*[@id='product-13228']/div[2]/div/h1")
    public WebElement electricFryingPan;


    @FindBy(xpath ="/html/body/div[2]/div[4]")
    public WebElement backToPage;

    @FindBy(xpath ="//*[@id='product-13226']/div[2]/div/h1")
    public WebElement electricRiceCooker;

    @FindBy(xpath ="//*[@id='product-13227']/div[2]/div/h1")
    public WebElement kitchenCooker;

    @FindBy(xpath ="/html/body/div[2]/div[3]/div/a[2]")
    public WebElement startCompareButton;


    @FindBy(xpath ="//div[@class='page-content']")
    public List<WebElement> comparePage;

    @FindBy(xpath ="//a[@data-product_id='13229']")
    public WebElement remove_13229;

    @FindBy(xpath ="//a[@data-product_id='13226']")
    public WebElement remove_13226;

    @FindBy(xpath ="//a[@data-product_id='13227']")
    public WebElement remove_13227;

    @FindBy(xpath ="//a[@data-product_id='13228']")
    public WebElement remove_13228;

    @FindBy(xpath ="//a[@data-product_id='13223']")
    public WebElement remove_13223;


    @FindBy(xpath ="//h1[@class='product_title entry-title']")
    public WebElement kitchenTable;

    @FindBy(xpath ="//*[@id='product-13223']/div[2]/div/div[4]/div[2]/div/a")
    public WebElement addToWishListKitchenTable;


    @FindBy(xpath ="//div[@class='wolmart-compare-table empty']")
    public List <WebElement> compareEmptyPage;

    @FindBy(xpath ="//a[@data-title='Browse wishlist...']")
    public WebElement addToWishList;

    @FindBy(xpath ="//*[@id='product-13257']/div[2]/div/h1")
    public WebElement comfortableBackpack;


    @FindBy(xpath =" //i[@class='w-icon-heart']")
    public WebElement wishListIcon;


    @FindBy(xpath =" //*[@class='page-wrapper']")
    public WebElement wishListPage;

    @FindBy(xpath ="//button[@title='Quick View']")
    public WebElement quickView;

    @FindBy(xpath ="//button[@title='Plus']")
    public WebElement plusButton;


    @FindBy(xpath ="//button[@title='Plus']")
    public WebElement minusButton;


    @FindBy(xpath ="//a[@aria-label='Add “Kitchen Table” to your cart']")
    public WebElement addToCartTable;

    @FindBy(xpath ="//a[@aria-label='Add “Comfortable Backpack” to your cart']")
    public WebElement addToCartBag;


    @FindBy(xpath ="//div[@class='widget_shopping_cart_content']")
    public WebElement cartContent;














}

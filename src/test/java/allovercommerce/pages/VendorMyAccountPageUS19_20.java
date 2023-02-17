package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorMyAccountPageUS19_20 {
    public VendorMyAccountPageUS19_20() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
        //******************* FUNDA US_19, US_20 *******************
    @FindBy(xpath = "//a[text()='Orders']")
    public WebElement orders;

    @FindBy(xpath = "//a[text()='Browse products']")
    public WebElement browseProducts;

    @FindBy(xpath = "//p[@class='greeting mb-0']")
    public WebElement greetingMessage;

    @FindBy(linkText = "Store Manager")
    public WebElement storeManager;
}

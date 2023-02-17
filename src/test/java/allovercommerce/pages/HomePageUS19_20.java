package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageUS19_20 {
    public HomePageUS19_20() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //******************* FUNDA US_19, US_20 *******************

    @FindBy(linkText = "Sign In")
    public WebElement singInButton;

    @FindBy(linkText = "Sign Out")
    public WebElement signOutButton;
    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement MyAccountLink;
}

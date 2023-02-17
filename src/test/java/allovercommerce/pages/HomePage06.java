package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage06 {
    public HomePage06 (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Sign In")
    public WebElement singInButton;

    @FindBy(linkText = "Sign Out")
    public WebElement signOutButton;





}


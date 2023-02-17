package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageUS_01 {

    public HomePageUS_01 (){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(linkText = "Register")
    public WebElement registerButton;

    @FindBy(xpath = "//h2[text()='My Account']")
    public WebElement myAccountText;

    @FindBy(xpath = "(//i[@class='w-icon-account'])[1]")
    public WebElement userIconButton;

    @FindBy(linkText = "Sign In")
    public WebElement signInOption;


}

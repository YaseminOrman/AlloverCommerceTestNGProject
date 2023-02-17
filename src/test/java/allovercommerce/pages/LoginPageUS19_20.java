package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageUS19_20 {
    public LoginPageUS19_20() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement signInButton;
}

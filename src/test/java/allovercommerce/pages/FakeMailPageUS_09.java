package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FakeMailPageUS_09 {

    public FakeMailPageUS_09() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(xpath = "a//[@title='Refresh mailbox']")
    public WebElement refresh;


    @FindBy(xpath = "//*[contains(text(), 'Email Verification Code')]")
    public WebElement verificationCodeText;



}

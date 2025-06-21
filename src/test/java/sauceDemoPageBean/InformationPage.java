package sauceDemoPageBean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage {

WebDriver ldriver;
	
	public InformationPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id="postal-code")
	WebElement postalCode;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(css=".error-message-container>h3")
	WebElement postalcodeErrMsg;
	
	public void enterFirstName(String fName)
	{
		firstName.sendKeys(fName);
	}
	
	public void enterLastName(String lName)
	{
		lastName.sendKeys(lName);
	}
	
	public void enterPostalCode(String pcode)
	{
		postalCode.sendKeys(pcode);
	}
	
	public void clickOncontinueBtn()
	{
		continueBtn.click();
	}
	
	public String errMsgForPostalCode()
	{
		return postalcodeErrMsg.getText();
	}
}

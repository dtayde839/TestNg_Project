package sauceDemoPageBean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(id = "user-name")
	WebElement userName;
	
	@FindBy(id = "password")
	WebElement passWord;
	
	@FindBy(id = "login-button")
	WebElement loginBtn;
	
	@FindBy(css=".error-message-container>h3")
	WebElement locked_out_user_err;
	
	public void enterUserName(String uName)
	{
		userName.sendKeys(uName);
	}
	
	public void enterPassword(String pwd)
	{
		passWord.sendKeys(pwd);
	}
	
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}
	
	public String getPageTitle()
	{
		return(ldriver.getTitle());
	}
	
	public String getLockedoutUserErrMsg()
	{
		return locked_out_user_err.getText();
	}
	
}

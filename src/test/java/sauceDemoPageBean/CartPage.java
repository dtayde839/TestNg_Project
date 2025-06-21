package sauceDemoPageBean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

WebDriver ldriver;
	
	public CartPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(id="checkout")
	WebElement checkOut;
	
	public void clickOnCheckOut()
	{
		checkOut.click();
	}
}

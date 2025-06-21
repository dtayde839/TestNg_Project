package sauceDemoPageBean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	WebDriver ldriver;

	public CheckoutPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(id="finish")
	WebElement finishBtn;
	
	@FindBy(className="inventory_item_price")
	WebElement itemPrice;
	
	public void clickOnfinishBtn()
	{
		finishBtn.click();
	}
	
	public String getItemPrice()
	{
		return itemPrice.getText();
	}
}

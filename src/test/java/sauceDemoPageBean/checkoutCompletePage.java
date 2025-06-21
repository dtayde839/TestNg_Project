package sauceDemoPageBean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutCompletePage {

	WebDriver ldriver;

	public checkoutCompletePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(css="#checkout_complete_container>h2")
	WebElement successMsg;
	
	public String getSuccessMsg()
	{
		return successMsg.getText();
	}
}

package sauceDemoTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import sauceDemoPageBean.CartPage;
import sauceDemoPageBean.CheckoutPage;
import sauceDemoPageBean.HomePage;
import sauceDemoPageBean.InformationPage;
import sauceDemoPageBean.InventoryPage;
import sauceDemoPageBean.checkoutCompletePage;

public class VerifyCheckoutPage extends BaseClass
{
	
	
	@Test(priority=1)
	public void verifyAmountonCheckoutPage()
	{
		  String expPrice = "$29.99";
		  HomePage pg = new HomePage(driver);
		  InventoryPage ip =new InventoryPage(driver);
		  CartPage cp = new CartPage(driver);
		  InformationPage inf = new InformationPage(driver);
		  CheckoutPage ccp = new CheckoutPage(driver);
		  
		  pg.enterUserName("standard_user");
		  pg.enterPassword("secret_sauce");
		  pg.clickOnLoginBtn();
		  
		  ip.clickonsauceLabsBackpackaadtoCart();
		  ip.clickOnCartIcon();
		  cp.clickOnCheckOut();
		  inf.enterFirstName("Dinesh");
		  inf.enterLastName("Tayde");
		  inf.enterPostalCode("421605");
		  inf.clickOncontinueBtn();
		  
		  String actPrice = ccp.getItemPrice();
		  System.out.println(actPrice);
		  Assert.assertEquals(actPrice, expPrice);
	}
	
	@Test(priority=2)
	public void verifySuccessMsg()
	{
		CheckoutPage cp = new CheckoutPage(driver);
		cp.clickOnfinishBtn();
		checkoutCompletePage ccp = new checkoutCompletePage(driver);
		String successMsg = ccp.getSuccessMsg();
		Assert.assertEquals(successMsg, "Thank you for your order!");
	}
	
	@Test(priority=3 )
	public void verifyCheckoutWithBlankPostalcode()
	{
		  HomePage pg = new HomePage(driver);
		  InventoryPage ip =new InventoryPage(driver);
		  CartPage cp = new CartPage(driver);
		  InformationPage inf = new InformationPage(driver);
		  
		  pg.enterUserName("standard_user");
		  pg.enterPassword("secret_sauce");
		  pg.clickOnLoginBtn();
		  
		  ip.clickonsauceLabsBackpackaadtoCart();
		  ip.clickOnCartIcon();
		  cp.clickOnCheckOut();
		  inf.enterFirstName("Dinesh");
		  inf.enterLastName("Tayde");
		  inf.enterPostalCode("");
		  inf.clickOncontinueBtn();
		  
		  String postalCodeerr = inf.errMsgForPostalCode();
		  
		  Assert.assertEquals(postalCodeerr, "Error: Postal Code is required");
	}
}

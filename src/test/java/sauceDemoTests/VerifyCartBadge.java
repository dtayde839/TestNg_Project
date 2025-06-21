package sauceDemoTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import sauceDemoPageBean.HomePage;
import sauceDemoPageBean.InventoryPage;

public class VerifyCartBadge extends BaseClass
{

	@Test
	public void verifyCartBadgeCountwithOneProductSelected()
	{
		  HomePage pg = new HomePage(driver);
		  InventoryPage ip =new InventoryPage(driver);
		  
		  pg.enterUserName("standard_user");
		  pg.enterPassword("secret_sauce");
		  pg.clickOnLoginBtn();
		  
		  ip.clickonsauceLabsBackpackaadtoCart();
		  String productCount = ip.getItemsCount();
		  
		  System.out.println(productCount);
		  Assert.assertEquals(productCount, "1");
	}
	
	@Test
	public void verifyCartBadgeCountWithTwoProductsSelected()
	{
		  HomePage pg = new HomePage(driver);
		  InventoryPage ip =new InventoryPage(driver);
		  
		  pg.enterUserName("standard_user");
		  pg.enterPassword("secret_sauce");
		  pg.clickOnLoginBtn();
		  ip.clickonsauceLabsBackpackaadtoCart();
		  ip.clickonsauceLabsBikeLightaddtoCart();
		  String productCount = ip.getItemsCount();
		  
		  System.out.println(productCount);
		  Assert.assertEquals(productCount, "2");
	}
	
		  
}

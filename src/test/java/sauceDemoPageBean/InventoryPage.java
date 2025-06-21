package sauceDemoPageBean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage
{
WebDriver ldriver;
	
	public InventoryPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(className="product_sort_container")
	WebElement sortContainer;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement sauceLabsBackpackaddtoCart;
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement sauceLabsBikeLightaddtoCart;
	
	@FindBy(className="shopping_cart_link")
	WebElement cartIcon;
	
	@FindBy(className="shopping_cart_badge")
	WebElement itemsCount;
	
	public void selectSorting(String selected)
	{
		Select sort = new Select(sortContainer);
		sort.selectByValue(selected);
	}
	
	public void clickonsauceLabsBackpackaadtoCart()
	{
		sauceLabsBackpackaddtoCart.click();
	}
	
	public void clickonsauceLabsBikeLightaddtoCart()
	{
		sauceLabsBikeLightaddtoCart.click();	
	}
	
	public void clickOnCartIcon()
	{
		cartIcon.click();
	}
	
	public String getItemsCount()
	{
		return itemsCount.getText();
	}
	
}

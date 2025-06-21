package sauceDemoTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sauceDemoPageBean.HomePage;
import sauceDemoPageBean.InventoryPage;

public class VerifySorting extends BaseClass
{
	@BeforeMethod
	public void login()
	{
		HomePage pg = new HomePage(driver);
		pg.enterUserName("standard_user");
		pg.enterPassword("secret_sauce");
		pg.clickOnLoginBtn();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.navigate().back();
	}
	
	@Test
	public void verifySortingLowtoHigh()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.selectSorting("lohi");
		
		List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
		List<Double> actualPrices = new ArrayList<>();
		
		for(WebElement priceEl : priceElements)
		{
			String priceText = priceEl.getText().replace("$", "");
            actualPrices.add(Double.parseDouble(priceText));
		}
		
		 // Make a copy and sort it for comparison
        List<Double> sortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedPrices);
        
        System.out.println(sortedPrices);

        Assert.assertEquals(actualPrices, sortedPrices, "Products are not sorted by price Low to High.");
	}
	
	@Test
	public void verifySortingHightoLow()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.selectSorting("hilo");
		
		List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
		List<Double> actualPrices = new ArrayList<>();
		
		for(WebElement priceEl : priceElements)
		{
			String priceText = priceEl.getText().replace("$", "");
            actualPrices.add(Double.parseDouble(priceText));
		}
		
		 // Make a copy and sort it for comparison
        List<Double> sortedPrices = new ArrayList<>(actualPrices);
        sortedPrices.sort(Comparator.reverseOrder());
        
        System.out.println(sortedPrices);

        Assert.assertEquals(actualPrices, sortedPrices, "Products are not sorted by price High to Low.");
	}
	
	@Test
	public void verifySortingAlphabeticallyAscending()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.selectSorting("az");
		
		List<WebElement> productElements = driver.findElements(By.className("inventory_item_name"));
		List<String> actualProductNames = new ArrayList<>();
		
		for(WebElement product : productElements)
		{
			actualProductNames.add(product.getText());
		}
		
//		System.out.println(actualProductNames);	

        List<String> sortedProductNames = new ArrayList<>(actualProductNames);
        Collections.sort(sortedProductNames);
        
        Assert.assertEquals(actualProductNames, sortedProductNames, "Products are not sorted alphabetically (A to Z).");
	}
	
	@Test
	public void verifySortingAlphabeticallyDescending()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.selectSorting("za");
		
		List<WebElement> productElements = driver.findElements(By.className("inventory_item_name"));
		List<String> actualProductNames = new ArrayList<>();
		
		for(WebElement product : productElements)
		{
			actualProductNames.add(product.getText());
		}
		
//		System.out.println(actualProductNames);	

        List<String> sortedProductNames = new ArrayList<>(actualProductNames);
        sortedProductNames.sort(Comparator.reverseOrder());
        
        System.out.println(sortedProductNames);
        
        Assert.assertEquals(actualProductNames, sortedProductNames, "Products are not sorted alphabetically (Z to A).");
	}
}

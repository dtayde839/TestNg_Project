package sauceDemoTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sauceDemoPageBean.HomePage;

public class VerifyLogin extends BaseClass
{
	@Test
	public void loginWithValidCredentials()
	{
		  String expectedTitle = "Swag Labs";
		  HomePage pg = new HomePage(driver);
		  pg.enterUserName("standard_user");
		  pg.enterPassword("secret_sauce");
		  pg.clickOnLoginBtn();
		  String actualTitle = driver.getTitle();
		  System.out.println(actualTitle);
		  Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(dataProvider="InvalidData", groups= {"group1"})
	public void loginWithinvalidCredentials(String username, String password)
	{
		  HomePage pg = new HomePage(driver);
		  pg.enterUserName(username);
		  pg.enterPassword(password);
		  pg.clickOnLoginBtn();
		  
		  if(username=="locked_out_user" && password=="secret_sauce")
		  {
			  String actErr = pg.getLockedoutUserErrMsg();
			  String expErr = "Epic sadface: Sorry, this user has been locked out.";
			  System.out.println(actErr);
			  
			  Assert.assertEquals(actErr, expErr);
			  
		  }
		  
//		  if(username=="standard123" && password=="secret_sauce")
//		  {
//			  System.out.println("Username is wrong");
//		  }
//		  
//		  if(username=="standard123" && password=="secret_sauce")
//		  {
//			  System.out.println("Username is wrong");
//		  } 
	}
	
	@AfterMethod(groups= {"group1"}, alwaysRun=false)
	public void getBack()
	{
		driver.navigate().refresh();
	}
	
	@DataProvider(name = "InvalidData")
    public Object[][] details()
    {
        return new Object[][] 
        		{
        	{"locked_out_user", "secret_sauce"},
            {"standard_user","secret123"},
            {"standard123", "secret_sauce"},
            {"standard123", "secret123"},
            {" ","secret_sauce"}, 
            {"standard_user"," "},
            {" ", "secret123"},
            {"standard123", " "},
            {" ", " "}
        };
    }
}

package sauceDemoTests;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{

	public static WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
	    ChromeOptions options = new ChromeOptions();

	    // Disable Chrome Password Manager
	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // Remove "Chrome is being controlled" infobar
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));

        // Disable notifications
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://www.saucedemo.com/");

	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	
	
}

package cpsat.handson.exercise.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

public class InitiateDriver {

	public WebDriver driver;
	public String url="www.google.com";
	
	@BeforeSuite
	@Before
	public void openBrowser() throws Exception {
	
		Properties p = new Properties();
		File propfile = new File("./ConfigFiles/AppConfig.properties");
		FileInputStream propfile_is = new FileInputStream(propfile);
		p.load(propfile_is);
		String browser = p.getProperty("Browser");
		
		if(browser.equalsIgnoreCase("Chrome")) {
			
			String driverlocation = p.getProperty("ChromeDriver");
			System.setProperty("webdriver.chrome.driver", driverlocation);
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			
			String driverlocation = p.getProperty("FirefoxDriver");
			System.setProperty("webdriver.gecko.driver", driverlocation);
			driver = new FirefoxDriver();
		}
		else{
			
			String driverlocation = p.getProperty("ChromeDriver");
			System.setProperty("webdriver.chrome.driver", driverlocation);
			driver = new ChromeDriver();
		}
		
		//modify the default timeouts\waits
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // for thep age to load
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // for an element to be identified.
		
		url = p.getProperty("URL");
		driver.navigate().to(url);
		driver.manage().window().maximize();
						
	}
	
	@AfterSuite
	@After
	public void closeBrowser() {
		//driver.close(); 				// this will close only the active tab/popup.
		driver.quit(); 				// this will close everything.
	}
}

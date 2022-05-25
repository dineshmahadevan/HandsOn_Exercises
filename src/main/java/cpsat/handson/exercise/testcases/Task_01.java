package cpsat.handson.exercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import cpsat.handson.exercise.base.InitiateDriver;
import cpsat.handson.exercise.library.TakeScreenshot;
import cpsat.handson.exercises.listener.DriverUpdate;


public class Task_01 extends InitiateDriver {
	
		TakeScreenshot screenshots = new TakeScreenshot();
			
		@Test(priority=1, groups="Q1")
		public void Task_01_A() {
			
			//EventFiringWebDriver eventdriver = new EventFiringWebDriver(driver);
			//DriverUpdate listener = new DriverUpdate();
			//eventdriver.register(listener);
			String pageTitle = driver.getTitle();
			
			System.out.println(pageTitle);
			Boolean flag = pageTitle.contains("Rediff");
			Assert.assertTrue(flag);
		}
		
		@Test(priority=2, groups="Q1")
		public void Task_01_B_C() {
			
			driver.findElement(By.linkText("SPORTS")).click();
			screenshots.take_Screenshot(driver, "Sports_Page");
			
		}
		
		@Test(priority=3, groups="Q1")
		public void Task_01_D() {
			
			List<WebElement> links = driver.findElements(By.xpath("//a"));
			for(WebElement element : links) {
				System.out.println(element.getAttribute("href"));
			}
		
		}
		
		@Test(priority=4, groups="Q1")
		public void Task_01_E() throws InterruptedException {
			
				Actions act = new Actions(driver);
				act.moveToElement(driver.findElement(By.xpath("//a[text()='CRICKET']"))).perform();
				Thread.sleep(5000);
				screenshots.take_Screenshot(driver, "Cricket_ToolTip");
				
		}
		
		@Test(priority=5, groups="Q1")
		public void Task_01_G() throws InterruptedException {
			
				driver.findElement(By.xpath("//a[text()='MOVIES']")).click();
				String bgcolor = driver.findElement(By.xpath("//div[@class='subnavbar movies']")).getCssValue("background");
				if(bgcolor.contains("rgb(199, 49, 89)")) {
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);	
				}
				
		}
		
		@Test(priority=6, groups="Q1")
		public void Task_01_H() throws InterruptedException {
			
				driver.get("https://www.color-blindness.com/color-name-hue/");
				driver.findElement(By.xpath("//input[@id='cp1_Red']")).clear();
				driver.findElement(By.xpath("//input[@id='cp1_Red']")).sendKeys("199");
				driver.findElement(By.id("cp1_Green")).clear();
				driver.findElement(By.id("cp1_Green")).sendKeys("49");
				driver.findElement(By.id("cp1_Blue")).clear();
				driver.findElement(By.id("cp1_Blue")).sendKeys("89");
				String colorname = driver.findElement(By.id("cp1_ColorNameText")).getText();
				Assert.assertEquals(colorname, "Old Rose");
		}
}

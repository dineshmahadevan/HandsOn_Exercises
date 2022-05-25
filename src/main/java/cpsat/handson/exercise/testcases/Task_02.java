package cpsat.handson.exercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import cpsat.handson.exercise.base.InitiateDriver;
import cpsat.handson.exercise.library.ReadDataFromExcel;
import cpsat.handson.exercise.library.TakeScreenshot;

public class Task_02 extends InitiateDriver {
	
	String menu, submenu, href;
	TakeScreenshot screenshot = new TakeScreenshot();
	ReadDataFromExcel exceldata = new ReadDataFromExcel();
	
	@Test
	public void verifyHref() throws IOException {
		
		for(int i = 1; i < 10; i++) {
			menu = exceldata.readData("./ConfigFiles/Menus_Href.xlsx", "Sheet1", i, 0).toUpperCase();
			submenu = exceldata.readData("./ConfigFiles/Menus_Href.xlsx", "Sheet1", i, 1);
			href = exceldata.readData("./ConfigFiles/Menus_Href.xlsx", "Sheet1", i, 2);
			driver.findElement(By.xpath("//*[text()='" + menu + "']")).click();
			String actualhref = driver.findElement(By.xpath("//a[text()='" + submenu + "']")).getAttribute("href");
			if(actualhref.equalsIgnoreCase(href)) {
				Assert.assertTrue(true);
				System.out.println("Href for the submenu is same " + actualhref);
			
			}
			else {
				System.out.println("Href for the submenu is not same " + actualhref);
				Assert.assertTrue(false);
			}
			driver.findElement(By.xpath("//a[text()='" + submenu + "']")).click();
			screenshot.take_Screenshot(driver, ("Question1_"+ submenu));
		}
	}
	
}

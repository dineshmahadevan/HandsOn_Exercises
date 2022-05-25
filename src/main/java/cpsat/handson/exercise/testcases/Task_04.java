package cpsat.handson.exercise.testcases;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cpsat.handson.exercise.base.InitiateDriver;
import cpsat.handson.exercise.library.WriteDataToExcel;

public class Task_04 extends InitiateDriver{
	
	WriteDataToExcel write = new WriteDataToExcel();
	
	@Test
	public void readAllTopStories() throws IOException {
		
		int rownumber = 0;
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='topdiv_0']/h2/a"));
		for(WebElement topstories : links){
			String linktext = topstories.getText().toString();
			String href = topstories.getAttribute("href").toString();
			write.writeData(linktext, href, rownumber);
			rownumber++;
		}
		
		write.saveFile();
				
	}
}

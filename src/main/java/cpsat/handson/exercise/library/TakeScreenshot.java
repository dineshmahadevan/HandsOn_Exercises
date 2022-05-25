package cpsat.handson.exercise.library;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	
	public static void take_Screenshot(WebDriver driver, String filename) {
		try {
			DateFormat df = new SimpleDateFormat("MM-d-yyyy HHMMSS");    
			Calendar cal = Calendar.getInstance();
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			//filename = "./Screenshots/" + filename + df.format(cal.getTime()) + ".png";
			filename = "./Screenshots/" + filename + ".png";
			File sshot = screenshot.getScreenshotAs(OutputType.FILE);
			File sshotfile = new File(filename);
			FileUtils.copyFile(sshot,  sshotfile);
		}
		catch(Exception e) {
			
			System.out.println("Unable to take screenshot");
			
		}
	}

}

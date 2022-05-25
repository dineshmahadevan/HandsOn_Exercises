package cpsat.handson.exercise.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		
	}

	
	@FindBy(xpath="//span[@id='bseindex']") WebElement bseindex;
	@FindBy(xpath="//span[@id='nseindex']") WebElement nseindex;
	@FindBy(xpath="//input[@name='query']") WebElement inputCompanyOrMF;
	@FindBy(xpath="//input[@type='submit' and @class='getqbtn']") WebElement searchButton;
	//@FindBy(cssSelector="iframe[@title='Rediff Money Widget']") WebEle
	
	public String getBSEIndex() {
		
		wait.until(ExpectedConditions.visibilityOf(bseindex));
		String value = bseindex.getText();
		return value;
	}
	
	public String getNSEIndex() {
		
		wait.until(ExpectedConditions.visibilityOf(nseindex));
		String value = nseindex.getText();
		return value;
		
	}
	
	public void setCompanyOrMF(String value) {
		
		wait.until(ExpectedConditions.visibilityOf(inputCompanyOrMF));
		inputCompanyOrMF.sendKeys(value);
		
	}
	
	public void searchCompanyOrMF() {
		wait.until(ExpectedConditions.visibilityOf(searchButton));
		searchButton.click();
	}
	
	public void moveToTab(int tabno) {
		
		String currentWindowHandle = driver.getWindowHandle();
		System.out.println(currentWindowHandle);
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(tabno));
				 
	}
	
	public void moveToFrame() {
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='moneyiframe']"));
		driver.switchTo().frame(frame);
		System.out.println(driver.getWindowHandle());
		
	}
	
	public void getPageTitle() {
		System.out.println("Current page Title is - " + driver.getTitle());
	}
	
	public void closeCurrentTab() {
		driver.close();
	}
}

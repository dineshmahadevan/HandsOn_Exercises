package cpsat.handson.exercise.testcases;


import org.junit.Test;
import org.openqa.selenium.support.PageFactory;


import cpsat.handson.exercise.base.InitiateDriver;
import cpsat.handson.exercise.pages.HomePage;

public class Task_03 extends InitiateDriver{
	
	@Test
	public void Task_03_A() {

		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		
		homepage.moveToFrame();
		String bseindex = homepage.getBSEIndex();
		System.out.println("BSE Index value is - " + bseindex);
		String nseindex = homepage.getNSEIndex();
		System.out.println("NSE Index value is - " + nseindex);
		homepage.setCompanyOrMF("HDFC Bank Ltd.");
		homepage.searchCompanyOrMF();
		homepage.moveToTab(1);
		homepage.getPageTitle();
		//homepage.closeCurrentTab();
		homepage.moveToTab(0);
		homepage.getPageTitle();
	}
	
}

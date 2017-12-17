package udemy.project;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LogInPage;
import resources.Base;

public class HomePage extends Base{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest()
	public void initializedriver() throws IOException
	{
		driver=initializeDriver();
		log.info("Browser initialed.");
		
	}
	
	@Test(dataProvider="getdata")
	public void basePageNavigation(String username, String password, String text) throws IOException
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to url");
		LandingPage lp = new LandingPage(driver);
		lp.getlogin().click();
		log.debug("Clicked on Login");
		LogInPage li= new LogInPage(driver);
		li.getEmail().sendKeys(username);
		log.debug("Entered username");
		li.password().sendKeys(password);
		log.debug("Entered password");
		log.info(text);
		li.submit().click();
	}
	@DataProvider
	public Object[][] getdata()
	{
		//rows stands for how many diff data types test should run
		//cols stands for how many values for each test
		Object[][] data= new Object[2][3];
		//0th row
		data[0][0]="nonrestricted@gmail.com";
		data[0][1]="1234";
		data[0][2]="restricted user";
		//1st row
		data[1][0]="sona.ahmed@gmail.com";
		data[1][1]="Newlife2123";
		data[1][2]="non restricted user";
		return data;
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
}

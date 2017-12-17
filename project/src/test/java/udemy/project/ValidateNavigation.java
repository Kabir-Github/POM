package udemy.project;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigation extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initializedriver() throws IOException {
		driver = initializeDriver();
		log.info("Driver initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to url");
	}

	@Test
	public void validatenavigation() throws IOException {

		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.navigation().isDisplayed());
		log.info("Sucessfully validated the navigation bar");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Driver closed");
		driver=null;
	}
}

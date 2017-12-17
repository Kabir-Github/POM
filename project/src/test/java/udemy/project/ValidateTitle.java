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

public class ValidateTitle extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initializedriver() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
	}

	@Test
	public void validatetitle() throws IOException {

		LandingPage lp = new LandingPage(driver);
		String av = lp.gettitle().getText();
		Assert.assertEquals(av, "FEATURED COURSE");
		log.info("Sucessfully validated");

	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
}

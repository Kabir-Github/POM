package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
	public WebDriver driver;
	public LogInPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By email= By.id("user_email");
	By password = By.id("user_password");
	By submit = By.name("commit");
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement password()
	{
		return driver.findElement(password);
	}
	public WebElement submit()
	{
		return driver.findElement(submit);
	}

}

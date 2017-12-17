package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By signin = By.xpath("//a[@href='http://qaclickacademy.usefedora.com/sign_in']");
	By title = By.xpath("//*[@id='content']/div/div/h2");
	By navigationbar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");

	public WebElement getlogin()
	{
		return driver.findElement(signin);
	}
	public WebElement gettitle()
	{
		return driver.findElement(title);
	}
	public WebElement navigation()
	{
		return driver.findElement(navigationbar);
	}
	
}

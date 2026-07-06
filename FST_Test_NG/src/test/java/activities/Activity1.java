package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	// Declare webdriver
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Initialize the driver object
		driver = new FirefoxDriver();

		// open the page
		driver.get("https://training-support.net");
	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		// assert the page title
		Assert.assertEquals(driver.getTitle(), "Training support");

	}
	
	@Test(priority = 2)
	public void clickAboutLink() {
		//locate about button
		driver.findElement(By.linkText("About Us")).click();
		// assert the page title
		Assert.assertEquals(driver.getTitle(), "About Training Support");

	}

	@AfterClass
	public void tearDown() {
		// close the browser
		driver.quit();
	}
}

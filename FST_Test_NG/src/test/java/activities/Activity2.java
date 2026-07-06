package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	// Declare webdriver
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Initialize the driver object
		driver = new FirefoxDriver();

		// open the page
		driver.get("https://training-support.net/webelements/target-practice");
	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		// assert the page title
		Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");

	}
	
	@Test(priority = 2)
	public void findBlackButton() {
		//locate black button
		String color = driver.findElement(By.xpath("//button[text() = 'Amber']")).getText();
		// assert the page title
		Assert.assertEquals(color, "Black");

	}
	
	@Test(enabled = false)
	public void thirdTest() {
		//locate black button
		driver.findElement(By.linkText("About Us")).click();
		// assert the page title
		Assert.assertEquals(driver.getTitle(), "About Training Support");

	}
	
	@Test
	public void fourthTest() {
		boolean skip = true;
		if(skip) {
			throw new SkipException("Test case is Skipped");
		}
		else {
			//locate black button
			driver.findElement(By.linkText("About Us")).click();
			// assert the page title
			Assert.assertEquals(driver.getTitle(), "About Training Support");
		}
	

	}

	@AfterClass
	public void tearDown() {
		// close the browser
		driver.quit();
	}
}

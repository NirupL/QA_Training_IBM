package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	// Declare webdriver
	WebDriver driver;
	WebDriverWait wait; 
	@BeforeClass
	public void setUp() {
		// Initialize the driver object
		driver = new FirefoxDriver();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// open the page
		driver.get("https://training-support.net/webelements/login-form");
	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		// assert the page title
		Assert.assertEquals(driver.getTitle(), "Selenium: Login Form");

	}

	@Test(priority = 2)
	public void validLoginTest() {
		// locate black button
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
		// assert the page title
	    wait.until(ExpectedConditions.titleIs("Selenium: Login Success!"));
		Assert.assertEquals(driver.getTitle(), "Selenium: Login Success!");


	}

	@AfterClass
	public void tearDown() {
		// close the browser
		driver.quit();
	}
}

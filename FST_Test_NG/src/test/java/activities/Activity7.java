package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity7 {
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
	
	@DataProvider(name = "InvalidCreds")
	public Object[][] creds(){
		return new Object[][] {
			{"admin", "wrongpassword"},
			{"wrongadmin", "password"},
			{"wrongadmin", "wrongpassword"},
			{"0_0", ":p"},
			
		};
	}

	@Test(priority = 2, dataProvider = "InvalidCreds")
    @Parameters({ "username", "password", "message" })
	public void validLoginTest(String username, String password) throws InterruptedException {
		// locate black button
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
		// assert the page title
		
		
		String message = driver.findElement(By.id("subheading")).getText();
		Assert.assertEquals(message, "Invalid credentials");
		
//	    wait.until(ExpectedConditions.titleIs("Selenium: Login Success!"));
//		Assert.assertEquals(driver.getTitle(), "Selenium: Login Success!");


	}
	@AfterMethod
	public void resetPage() {
		driver.navigate().refresh();
	}

	@AfterClass
	public void tearDown() {
		// close the browser
		driver.quit();
	}
}

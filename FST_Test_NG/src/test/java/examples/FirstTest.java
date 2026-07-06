package examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {
	//Declare webdriver
	WebDriver driver;
	
  @BeforeClass
  public void setUp() {
	  //Initialize the driver object
	  driver = new FirefoxDriver();
	  
	  //open the page
	  driver.get("https://training-support.net");
  }
	 
  @Test(priority = 1)
  public void verifyPageTitle() {
	  //assert the page title
	  Assert.assertEquals(driver.getTitle(),"Training Support");
	  
  }
 

  @AfterClass
  public void tearDown() {
	  //close the browser
	  driver.quit();
  }

}

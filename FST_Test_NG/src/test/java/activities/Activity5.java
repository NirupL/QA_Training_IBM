package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	// Declare webdriver
	WebDriver driver;
	WebDriverWait wait; 
	
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		// Initialize the driver object
		driver = new FirefoxDriver();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// open the page
		driver.get("https://training-support.net/webelements/target-practice");
	}

	@Test(groups = {"headingTests"})
	public void headerTest1(){
		String heading3 = driver.findElement(By.xpath("//h3[contains(@class,' text-orange-600')]")).getText();
		Assert.assertEquals(heading3, "Heading #3");
	}
	
	@Test(groups = {"headingTests"})
	public void headerTest2(){
		WebElement heading5 = driver.findElement(By.xpath("//h5[contains(@class,' text-purple-600')]"));
		String heading5Color = heading5.getCssValue("color");
		Assert.assertEquals(heading5Color, "rgb(147, 51, 234)");
		Assert.assertEquals(Color.fromString(heading5Color).asHex(), "#9333ea");
	}
	
	@Test(groups = {"buttonTests"})
	public void buttonTest1() {
		String purplebutton = driver.findElement(By.xpath("//button[text() = 'Purple']")).getAttribute("class");
		Assert.assertEquals(purplebutton, "rounded-xl bg-purple-200 p-2 text-3xl font-bold text-purple-900 svelte-2hb4ib");
		Assert.assertTrue(purplebutton.contains("text-purple-900"));
	}
	
	@Test(groups = {"buttonTests"})
	public void buttonTest2() {
		String slatebutton = driver.findElement(By.xpath("//button[text() = 'Slate']")).getText();
		Assert.assertEquals(slatebutton, "Slate");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		// close the browser
		driver.quit();
	}
}

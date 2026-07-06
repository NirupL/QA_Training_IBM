package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity3 {

	public static void main(String[] args) {
		// Create an instance of WebDriver
		WebDriver driver = new FirefoxDriver();
		//implicit wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//initialize the wait object
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		

		try {
			// Open the test page
			driver.get(" https://training-support.net/webelements/login-form/");

			System.out.println("Page title is : "+driver.getTitle());
			
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			
			//explicit wait
			
			String succesHeading =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(@class,'text-emerald-500')]"))).getText();
			System.out.println(succesHeading);
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		} finally {
			// Close the browser
//			driver.quit(); // close all windows/tab
		}

	}

}

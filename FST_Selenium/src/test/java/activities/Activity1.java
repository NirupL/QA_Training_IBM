package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// Create an instance of WebDriver
		WebDriver driver = new FirefoxDriver();

		try {
			// Open the test page
			driver.get("https://training-support.net/");
			
			//print the page title
			System.out.println("Page title is : "+driver.getTitle());

			//click the about button
			driver.findElement(By.linkText("About Us")).click();
			
			//print the title of new page
			System.out.println("Title of new page : "+driver.getTitle());
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		} finally {
			// Close the browser
//			driver.quit(); // close all windows/tab
//			driver.close(); // close the active window/tab
		}

	}

}

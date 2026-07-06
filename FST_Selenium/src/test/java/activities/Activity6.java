package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {

	public static void main(String[] args) {
		// Create an instance of WebDriver
				WebDriver driver = new FirefoxDriver();

				try {
					// Open the test page
					driver.get(" https://training-support.net/webelements/dynamic-controls");
					
					System.out.println("Page title is : "+driver.getTitle());
					
					//find the checkbox input element
					WebElement checkbox = driver.findElement(By.id("checkbox"));
					
					//check if it is visible on the page
					System.out.println("Is the checkbox selected? : " +checkbox.isSelected());
					
					//click the remove checkbox button
					checkbox.click();
					
					//check if the checkbox is visible again or not
					System.out.println("Is the checkbox selected? : " +checkbox.isSelected());

					
				} catch (Exception exp) {
					System.out.println(exp.getMessage());
				} finally {
					// Close the browser
					driver.quit(); // close all windows/tab
//					
				}


	}

}

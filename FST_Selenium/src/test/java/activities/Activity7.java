package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {

	public static void main(String[] args) {
		// Create an instance of WebDriver
		WebDriver driver = new FirefoxDriver();

		try {
			// Open the test page
			driver.get(" https://training-support.net/webelements/dynamic-controls");
			
			System.out.println("Page title is : "+driver.getTitle());
			
			//find the checkbox input element
			WebElement textbox = driver.findElement(By.id("textInput"));
			
			//check if it is visible on the page
			System.out.println("Is the text is enabled? : " +textbox.isEnabled());
			
			//click the remove checkbox button
			driver.findElement(By.id("textInputButton")).click();
			
			//check if the checkbox is visible again or not
			System.out.println("Is the text is enabled? : " +textbox.isEnabled());
			textbox.sendKeys("Test text");
			
			//To get the text from the input text box
			String text = textbox.getDomProperty("value");
			System.out.println(text);

			
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		} finally {
			// Close the browser
			driver.quit(); // close all windows/tab
//			
		}

	}

}

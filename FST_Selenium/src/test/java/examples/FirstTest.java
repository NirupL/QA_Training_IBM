package examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {

	public static void main(String[] args) {
		// Create an instance of WebDriver
		WebDriver driver = new FirefoxDriver();

		try {
			// Open the test page
			driver.get("https://training-support.net/");

			// performing actions on that page
			// Assertions
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		} finally {
			// Close the browser
//			driver.quit(); // close all windows/tab
//			driver.close(); // close the active window/tab
		}

	}

}

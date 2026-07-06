package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity14 {
	public static void main(String[] args) {
		// Create the driver object
		WebDriver driver = new FirefoxDriver();

		try {
			// Open the page
			driver.get("https://training-support.net/webelements/tables");
			// Print the current page's title
			System.out.println("Current page's title: " + driver.getTitle());

			// Find the number of rows and columns in the table and print them.
			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
			List<WebElement> cols = driver.findElements(By.xpath("//table/thead/tr/th"));
			System.out.println("Rows: " + rows.size() + " Columns: " + cols.size());
			// Find and print the book's name from the 5th row before sorting the table by price
			WebElement bookName = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
			System.out.println("Before sorting, book's name is: " + bookName.getText());
			// Sort the table by price
			driver.findElement(By.xpath("//th[text()='Price']")).click();
			// Find and print the book's name from the 5th row after sorting the table by price
			bookName = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
			System.out.println("Before sorting, book's name is: " + bookName.getText());
		} catch (Exception exp) {
			// Print the error message
			System.out.println(exp.getMessage());
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}
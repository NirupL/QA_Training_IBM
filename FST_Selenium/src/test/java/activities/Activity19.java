package activities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import com.sun.org.apache.bcel.internal.generic.Select;

public class Activity19 {

	public static void main(String[] args) {
//		Open a new browser to https://training-support.net/webelements/alerts
//			Get the title of the page and print it to the console.
//			Find the button to open a SIMPLE alert and click it.
//			Switch the focus from the main window to the Alert box and get the text in it and print it.
//			Close the alert once with OK.
//			Close the browser.
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {			

			driver.get("https://training-support.net/webelements/alerts");
			System.out.println("title of the page is :"+driver.getTitle());
			
			driver.findElement(By.id("confirmation")).click();
			
			Alert confirmAlert = driver.switchTo().alert();
			System.out.println(confirmAlert.getText());
			
//			confirmAlert.accept();
			confirmAlert.dismiss();
			
			String message = driver.findElement(By.id("result")).getText();
			System.out.println(message);
			

		} catch (Exception exp) {
			System.out.println(exp.getMessage());

		} finally {

			driver.close();// close active window/tab

		}


	}

}
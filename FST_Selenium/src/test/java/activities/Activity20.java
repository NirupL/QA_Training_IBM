package activities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import com.sun.org.apache.bcel.internal.generic.Select;

public class Activity20 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {			

			driver.get("https://training-support.net/webelements/alerts");
			System.out.println("title of the page is :"+driver.getTitle());
			
			driver.findElement(By.id("prompt")).click();
			
			Alert promptAlert = driver.switchTo().alert();
			promptAlert.sendKeys("hello");
			System.out.println(promptAlert.getText());
			
			promptAlert.accept();
//			promptAlert.dismiss();
			
			String message = driver.findElement(By.id("result")).getText();
			System.out.println(message);
			

		} catch (Exception exp) {
			System.out.println(exp.getMessage());

		} finally {

			driver.close();// close active window/tab

		}


	}

}
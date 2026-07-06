package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity4 {

	public static void main(String[] args) {
		// Create an instance of WebDriver
				WebDriver driver = new FirefoxDriver();
				//implicit wait
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				//initialize the wait object
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				

				try {
					// Open the test page
					driver.get(" https://training-support.net/webelements/target-practice");

					System.out.println("Page title is : "+driver.getTitle());
					
					System.out.println(driver.findElement(By.xpath("//h3[contains(@class,' text-orange-600')]")).getText());
					System.out.println(driver.findElement(By.xpath("//h5[contains(@class,' text-purple-600')]")).getCssValue("color"));
					
					//OR
					
					//TO FIND COLOR OF THE HEADING
//					WebElement heading5 = driver.findElement(By.xpath("//h5[contains(@class,' text-purple-600')]"));
//					String heading5Color = heading5.getCssValue("color");
//					System.out.println(Color.fromString(heading5Color).asHex());
//					System.out.println(Color.fromString(heading5Color).asRgb());
//					System.out.println(Color.fromString(heading5Color).asRgba());
					
					System.out.println(driver.findElement(By.xpath("//button[text() = 'Purple']")).getAttribute("class"));
					System.out.println(driver.findElement(By.xpath("//button[text() = 'Slate']")).getText());
					
					//explicit wait
					
//					String succesHeading =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(@class,'text-emerald-500')]"))).getText();
//					System.out.println(succesHeading);
				} catch (Exception exp) {
					System.out.println(exp.getMessage());
				} finally {
					// Close the browser
					driver.quit(); // close all windows/tab
				}

	}

}

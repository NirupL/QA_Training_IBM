package activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12 {

	public static void main(String[] args) {
WebDriver driver = new FirefoxDriver();
		
		Actions builder = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			driver.get("https://training-support.net/webelements/drag-drop");

			System.out.println("Title is : " + driver.getTitle());

			WebElement image = driver.findElement(By.id("ball"));
			WebElement dropzone1 = driver.findElement(By.id("dropzone1"));
			WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
			List<WebElement> dropzoneTexts = driver.findElements(By.cssSelector("span.dropzone-text"));
			
			System.out.println("Before any action :" +dropzoneTexts.get(0).getText());
			
			builder.clickAndHold(image).moveToElement(dropzone1).release().build().perform();
			
			System.out.println("For dropzone 1 :"+dropzoneTexts.get(0).getText());
			System.out.println("Before dropzone 2 : "+dropzoneTexts.get(1).getText());
			
			builder.dragAndDrop(image, dropzone2).build().perform();
			
			System.out.println("For dropzone 2 : "+dropzoneTexts.get(1).getText());
			

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			driver.quit();
		}

	}

}

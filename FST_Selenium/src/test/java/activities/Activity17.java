package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity17 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		Actions builder = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			driver.get("https://training-support.net/webelements/selects");

			System.out.println("Title is : " + driver.getTitle());

			WebElement dp = driver.findElement(By.cssSelector("select.h-80"));

			Select multilist = new Select(dp);
			
			multilist.selectByVisibleText("HTML");
			
			multilist.selectByIndex(3);
			multilist.selectByIndex(4);
			multilist.selectByIndex(5);
			
			multilist.selectByValue("nodejs");
			
			multilist.deselectByIndex(4);
			
			System.out.println("selected options are : ");
			for(WebElement op : multilist.getAllSelectedOptions()) {
				System.out.println(op.getText());
			}

			

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			driver.quit();
		}

	}

}

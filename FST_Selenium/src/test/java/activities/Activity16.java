package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity16 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		Actions builder = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			driver.get("https://training-support.net/webelements/selects");

			System.out.println("Title is : " + driver.getTitle());

			WebElement dp = driver.findElement(By.cssSelector("select.h-10"));

			Select slt = new Select(dp);

			slt.selectByVisibleText("One");
			System.out.println(slt.getFirstSelectedOption().getText());

			slt.selectByIndex(2);
			System.out.println(slt.getFirstSelectedOption().getText());

			slt.selectByValue("three");
			System.out.println(slt.getFirstSelectedOption().getText());

			System.out.println("all the options");
			for (WebElement op : slt.getOptions()) {
				System.out.println(op.getText());
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			driver.quit();
		}

	}

}

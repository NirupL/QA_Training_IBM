package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps extends BaseClass {
		@Given("the user is on the login page")
		public void openLoginpage() {
			driver.get("https://training-support.net/webelements/login-form");
		}
		
		@When("the user enters username and password")
		public void enterUserPass() {
			driver.findElement(By.id("username")).sendKeys("admin");
			driver.findElement(By.id("password")).sendKeys("password");
		}
		
		@When("the user enters {string} and {string}")
		public void enterUserPassWithParam(String username, String password) {
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
		}
		
		@And("clicks the submit button")
		public void clickSubmit() {
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
		}
		
		@Then("get the confirmation message and verify it")
		public void verifyPageRedirect() {
			wait.until(ExpectedConditions.titleIs("Selenium: Login Success!"));
			Assertions.assertEquals(driver.getTitle(), "Selenium: Login Success!");
		}
		
		@Then("the {string} message is displayed")
		public void verifyFailMessage(String expectedMessage) {
			String message = driver.findElement(By.id("subheading")).getText();
			Assertions.assertEquals(message, expectedMessage);
		}
}

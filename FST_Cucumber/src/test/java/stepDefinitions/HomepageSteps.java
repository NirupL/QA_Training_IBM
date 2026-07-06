package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomepageSteps extends BaseClass {
		@Given("the user has opened the TS homepage")
		public void openTSHomepage() {
			driver.get("https://training-support.net");
		}
		
		@When("they click the About Us link")
		public void clickAboutLink() {
			driver.findElement(By.linkText("About Us")).click();
		}
		
		@Then("they are redirected to the About Us page")
		public void verifyPageRedirect() {
			Assertions.assertEquals(driver.getTitle(), "About Training Support");
		}
}

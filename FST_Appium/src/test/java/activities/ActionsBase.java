package activities;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.devtools.v143.input.model.MouseButton;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;

public class ActionsBase {
	//initializing the pointer
	private final PointerInput finger = new PointerInput(Kind.TOUCH,"finger");
	
	//function to emulate swipe(drag/flick)
	public void doSwipe(AppiumDriver driver, int duration, Point start, Point end) {
		//create the sequence of actions
		Sequence swipe = new Sequence(finger, 1);
		
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), start.getX(), start.getY()));
		swipe.addAction(finger.createPointerDown(0)); //left click
//		swipe.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(duration), Origin.viewport(), end.getX(), end.getY()));
		swipe.addAction(finger.createPointerUp(0));
		
		//perform the sequence of actions
		driver.perform(Arrays.asList(swipe));
	}
}

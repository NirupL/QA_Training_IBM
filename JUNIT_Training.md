DAY 5: MONDAY(June 01) ----JUNIT----



&#x09;-have assert functions - assertequals(),assertrue()

&#x09;-have @parametrizedTest()

&#x09;-assertion error and an exception are the only two conditions where "@Test" case fails, by default it is pass.

&#x09;-assertequals(Expected value, default/actual value)



Ex:

&#x09;**Test plan:**

Conditions	Rule 1	Rule 2	Rule 3 / 4 (Collapsed)

Is Premium Member?	TRUE	TRUE	FALSE

Order > $100?	TRUE	FALSE	Don't Care (-)

Actions

Apply 20% Discount	X

Apply 10% Discount		X

Apply 0% Discount			X





// Application Code to test:

public class DiscountCalculator {

&#x20;   public double calculateDiscountPercentage(boolean isPremium, double orderAmount) {

&#x20;       if (isPremium) {

&#x20;           return (orderAmount > 100.0) ? 0.20 : 0.10;

&#x20;       }

&#x20;       return 0.0;

&#x20;   }

}



**// JUnit test case:**

import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;



class DiscountCalculatorTest {



&#x20;   private final DiscountCalculator calculator = new DiscountCalculator();



&#x20;   @ParameterizedTest(name = "Rule {index}: Premium={0}, Amount={1} => Expected Discount={2}")

&#x20;   @CsvSource({

&#x20;       // isPremium, orderAmount, expectedDiscount

&#x20;       "true,       150.0,       0.20",  // Rule 1: Premium + Over $100

&#x20;       "true,       50.0,        0.10",  // Rule 2: Premium + Under $100

&#x20;       "false,      200.0,       0.00",  // Rule 3: Non-Premium + Over $100

&#x20;       "false,      30.0,        0.00"   // Rule 4: Non-Premium + Under $100

&#x20;   })

&#x20;   void testCalculateDiscountPercentage(boolean isPremium, double orderAmount, double expectedDiscount) {

&#x20;

&#x20;       double actualDiscount = calculator.calculateDiscountPercentage(isPremium, orderAmount);

&#x20;

&#x20;       assertEquals(expectedDiscount, actualDiscount, 0.001,

&#x20;           String.format("Failed for Premium: %s, Amount: %s", isPremium, orderAmount));

&#x20;   }

}





\-----------------------------------------PYTHON-------------------------------------------





\-interpreted lang


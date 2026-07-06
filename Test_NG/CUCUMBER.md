CUCUMBER:



Cucumber slides: https://slides.com/d/mgP6CY0/live





\* Feature file: (executable file in Cucumber)

&#x20;   Given the user is on the TS homepage

&#x20;   When they click on the About Us link

&#x20;   Then they are redirected to the About Us page

\* Step Definition: Java methods that implement the steps defined in the Feature file

&#x20;   @Given("the user is on the TS homepage")

&#x20;   public void openTSHomepage() {

&#x20;       // Open the TS homepage

&#x20;   }

&#x20;   @When("they click on the About Us link")

&#x20;   public void clickAboutLink() {

&#x20;       // Locate the About link and click it

&#x20;   }

&#x20;   @Then("they are redirected to the About Us page")

&#x20;   public void verifyAboutPage() {

&#x20;       // Verify redirect to About page

&#x20;   }

\* TestRunner: Test suite/Execution Control file





HOOKS:

@Before : runs before each scenario

@BeforeAll : runs before all scenario

@After : runs after each scenario

@Afterall : runs after all scenario



Tagged hooks : 

&#x09;-used for filtering



\* Hooks:

&#x20;   - Before: Runs before EACH scenario

&#x20;   - After: Runs after EACH scenario

&#x20;   - BeforeAll: Runs before ALL scenarios

&#x20;   - AfterAll: Runs after ALL scenario

\* Tagged Hooks:

&#x20;   - Before("@TagName") -> Setup for a particular scenario

&#x20;   - After("@TagName") -> Tear down for a particular scenario



**Parameterization int Cucumber:**

&#x09;-Use inside double quotes in Scenarios in feature file and call them in step definition file as parameters inside braces

&#x09;-Use Scenario outlines with examples in feature file and call them in the step definition file

&#x09;-Use DataTable for calling parameters


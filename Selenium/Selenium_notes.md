https://training-support.net/


**Selenium Commands:**

\* Browser commands:

&#x20;   \* get

&#x20;   \* getTitle

&#x20;   \* close

&#x20;   \* quit

\* Navigation commands:

&#x20;   \* back

&#x20;   \* forward

&#x20;   \* refresh

\* WebElement commands:

&#x20;   - Action:

&#x20;       \* click() -> Left click

&#x20;       \* sendKeys() -> Typing text into an input field

&#x20;       \* clear() -> Clear the text from an input field

&#x20;       \* submit() -> Submitting a form

&#x20;   - Accessor:

&#x20;       \* getText() -> Getting the text from a web element

&#x20;       \* getAttribute() -> Getting the value of an attribute from a web element

&#x20;       \* getDomProperty() -> Getting the value of a DOM property from a web element

&#x20;           - Used mostly for getting the value from an input field

&#x20;       \* getCssValue() -> Getting the value of a CSS property from a web element

&#x20;   - Assertion: return boolean

&#x20;       \* isDisplayed() -> Checking if a web element is visible on the page

&#x20;       \* isEnabled() -> Checking if a web element is enabled (interactable)

&#x20;       \* isSelected() -> Checking if a web element (like a checkbox or radio button) is selected


-----------------------------------------------------------------------------------------------------------




To find a single element: findElement() -> WebElement

&#x20;   - Return a NoSuchElementException when elements are not found

To find a multiple element: findElements() -> List<WebElement>

&#x20;   - Returns an empty list when elements are not found



findElement take a locator as arguments. Locators come from the By class

\* By.id("value")

\* By.name("name") -> Used mainly for inputs

\* By.className("one class")

\* By.cssSelector("css patterns")

\* By.xpath("xpath expression") -a> Most versatile locator

\* By.linkText("link text") -> Used only for anchor tag <a>

\* By.partialLinkText("partial link text") -> Used only for anchor tag <a>

\* By.tagName("tag")

-------------------------------------------------------------------------------------------------------------

**Selenium waits:**

\* Implicit Wait: 

&#x20;   - Implemented through driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5))

&#x20;   - Should be in the program, before any interactions. Only needs to be set once.

&#x20;   - If the action is not complete in the timeout time, throws a TimeoutException

&#x20;   - It checks for the presence of elements every 500ms.



\* Explicit wait:

&#x20;   - Implemnted using WebDriverWait object

&#x20;   - Wait conditions are in ExpectedConditions class: https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html

&#x20;   - Example usage:

&#x20;   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

&#x20;   wait.until(ExpectedConditions.conditionMethods(WebElement or locator));

&#x20;   - This also checks the condition every 500ms



\-- Do not use implicit and explicit wait together. Explicit will always override the implicit wait



Relative XPath:

//tagName\[@attribute='value']

//tagName\[text() = 'value']

//tagName\[contains(@attribute | text(), 'value')]

//tagName\[starts-with(@attribute, 'substring')]


--------------------------------------------ACTIONS----------------------------------------

* Create the Actions
Actions builder = new Actions(driver);

* Create the sequence of actions to perform:
builder.clickAndHold(WebElement).moveToElement(destWebElement).release().build().perform();

builder.contextClick(WebElement).perform();

-------------------------------------------SELECTS-----------------------------------------


To interact with a Select element:
* Find the webelement using findElement():  WebElement selectElem = driver.findElement(By.locator);
* Pass that webelement to the Select class constructor: Select dropdown = new Select(selectElem);

To interact with a dropdown:
* Select options by index: dropdown.selectByIndex()
* Select options by value: dropdown.selectByValue()
* Select options by visible text: dropdown.selectByVisibleText() [Recommended]
* To get the selected option: dropdown.getFirstSelectedOption() -> WebElement
* To get all the options: dropdown.getOptions() -> List<WebElement>

To interact with multilists:
* Select options by index: multilist.selectByIndex()
* Select options by value: multilist.selectByValue()
* Select options by visible text: multilist.selectByVisibleText() [Recommended]
* De-Select options by index: multilist.deselectByIndex()
* De-Select options by value: multilist.deselectByValue()
* De-Select options by visible text: multilist.deselectByVisibleText() [Recommended]
* To get all the options: multilist.getOptions() -> List<WebElement>
* To get the selected option: multilist.getFirstSelectedOption() -> WebElement
* To get ALL the selected options: multilist.getAllSelectedOptions() -> List<WebElement>


-------------------------------------------------ALERTS----------------------------------------



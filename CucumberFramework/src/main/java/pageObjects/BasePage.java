package pageObjects;

import java.time.Duration;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverFactory;

public class BasePage extends DriverFactory {

	protected WebDriverWait wait;
	protected JavascriptExecutor jsExecutor;

	public BasePage(WebDriver driver) throws Exception {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		jsExecutor = ((JavascriptExecutor) driver);
	}

//-------------------------------------------------------------------------------------------------	
// Click methods
//-------------------------------------------------------------------------------------------------	

	public void waitAndClickElement(WebElement element) throws InterruptedException {
		boolean clicked = false;
		int attempts = 0;

		while (clicked == false && attempts < 10) {

			try {
				wait.until(ExpectedConditions.elementToBeClickable(element)).click();
				System.out.println("Successfully Clicked on the WebElement " + "<" + element.toString() + ">");
				clicked = true;

			} catch (Exception e) {
				System.out.println("Unable to wait and click on the WebElement, Exception = " + e.getMessage());
				Assert.fail("Unable to wait and click on the WebElement" + "<" + element.toString() + ">");
			}
			attempts++;

		}
	}

	public void waitAndClickElementUsingByLocator(By byElement) throws InterruptedException {
		boolean clicked = false;
		int attempts = 0;

		while (clicked == false && attempts < 10) {

			try {
				wait.until(ExpectedConditions.elementToBeClickable(byElement)).click();

				System.out.println("Successfully Clicked on the element " + "<" + byElement.toString() + ">");
				clicked = true;

			} catch (Exception e) {
				System.out.println("Unable to wait and click on the element, Exception = " + e.getMessage());
				Assert.fail("Unable to wait and click on the element" + "<" + byElement.toString() + ">");
			}
			attempts++;

		}
	}

// -------------------------------------------------------------------------------------------------
// Action Click methods
// -------------------------------------------------------------------------------------------------

	public void actionMoveAndClickonWebElement(WebElement element) throws InterruptedException {

		Actions actions = new Actions(driver);

		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
			actions.moveToElement(element).build().perform();
			System.out.println("Successfully Clicked on the element " + "<" + element.toString() + ">");

		} catch (StaleElementReferenceException stale) {
			boolean blnElementPresent = wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
			if (blnElementPresent == true) {
				actions.moveToElement(element).build().perform();
				System.out.println("Successfully Clicked on the element " + "<" + element.toString() + ">");
			}
		} catch (Exception e) {
			System.out.println("Unable to wait and click on the element, Exception = " + e.getMessage());
			Assert.fail("Unable to wait and click on the element" + "<" + element.toString() + ">");
		}

	}

	public void actionMoveAndClick(By byElement) throws InterruptedException {

		Actions actions = new Actions(driver);

		try {
			wait.until(ExpectedConditions.elementToBeClickable(byElement)).isEnabled();
			WebElement element = driver.findElement(byElement);
			actions.moveToElement(element).build().perform();
			System.out.println("Successfully Clicked on the element " + "<" + element.toString() + ">");

		} catch (StaleElementReferenceException stale) {
			WebElement element = driver.findElement(byElement);
			boolean blnElementPresent = wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
			if (blnElementPresent == true) {
				actions.moveToElement(element).build().perform();
				System.out.println("Successfully Clicked on the element " + "<" + element.toString() + ">");
			}
		} catch (Exception e) {
			System.out.println("Unable to wait and click on the element, Exception = " + e.getMessage());
			Assert.fail("Unable to wait and click on the element" + "<" + byElement.toString() + ">");
		}

	}

// -------------------------------------------------------------------------------------------------
// SendKeys methods
// -------------------------------------------------------------------------------------------------

	public void sendKeys(WebElement element, String textToEnter) throws InterruptedException {

		try {

			element.clear();
			element.sendKeys(textToEnter);
			System.out.println("Successfully Enter the following text " + textToEnter + " to  the " + "<"
					+ element.toString() + ">");
		} catch (Exception e) {
			System.out.println("Unable to send keys to the element, Exception = " + e.getMessage());
			Assert.fail("Unable to send keys to the element" + "<" + element.toString() + ">");
		}
	}

// -------------------------------------------------------------------------------------------------
// Javascript  methods
// -------------------------------------------------------------------------------------------------

	public void scrollToElementBYWebElementLocator(WebElement element) throws InterruptedException {

		try {

			this.wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
			((JavascriptExecutor) driver).executeAsyncScript("arguments[0].scrollIntoView();", element);
			((JavascriptExecutor) driver).executeAsyncScript("window.scrollBy(0.-400)");
			System.out.println("Successfully scroll to the element using locator" + "<" + element.toString() + ">");
		} catch (Exception e) {
			System.out.println("Unable to scroll to the element using locator " + "<" + element + ">");
			Assert.fail("Unable to scroll to the element, Exception = " + e.getMessage());
		}
	}

	public void scrollToElementBuUsingScrollMethod(int numX, int numY) throws InterruptedException {

		try {

			((JavascriptExecutor) driver).executeAsyncScript("scroll(" + numX + "," + numY + ")");
			((JavascriptExecutor) driver).executeAsyncScript("window.scrollBy(0.-400)");
			System.out.println("Successfully scroll to the element using locator" + "<" + numX + " and " + numY + ">");
		} catch (Exception e) {
			System.out.println("Unable to scroll to the element using locator " + "<" + numX + " and " + numY + ">");
			Assert.fail("Unable to scroll to the element, Exception = " + e.getMessage());
		}
	}

	public void clickByUsingJavascripy(WebElement element) throws InterruptedException {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
			System.out.println("Successfully Clicked on the element " + "<" + element.toString() + ">");

		} catch (StaleElementReferenceException stale) {
			boolean blnElementPresent = wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
			if (blnElementPresent == true) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
				System.out.println("Successfully Clicked on the element " + "<" + element.toString() + ">");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Unable to click on the element, Exception = " + e.getMessage());
			Assert.fail("Unable to click on the element" + "<" + element.toString() + ">");
		}

	}

	public void jsClick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
	}

// -------------------------------------------------------------------------------------------------
// dropdown  methods
// -------------------------------------------------------------------------------------------------

	public boolean selectFromDropdownByVisibleText(WebElement element, String textToSelect)
			throws InterruptedException {

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select = new Select(element);
			select.selectByVisibleText(textToSelect);
			System.out.println("Option is Selected using the locator:" + "<" + element.toString() + ">");
			return true;

		} catch (Exception e) {
			System.out.println("Option is not Selected using the locator:" + "<" + element.toString() + ">");
			Assert.fail("Option is not selected, Exception" + e.getMessage());
			return false;
		}

	}

	public boolean selectFromDropdownByValue(WebElement element, String textToSelect) throws InterruptedException {

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select = new Select(element);
			select.selectByValue(textToSelect);
			System.out.println("Option is Selected using the locator:" + "<" + element.toString() + ">");
			return true;

		} catch (Exception e) {
			System.out.println("Option is not Selected using the locator:" + "<" + element.toString() + ">");
			Assert.fail("Option is not selected, Exception" + e.getMessage());
			return false;
		}

	}

	public boolean selectFromDropdownByValue(WebElement element, int index) throws InterruptedException {

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select = new Select(element);
			select.selectByIndex(index);
			System.out.println("Option is Selected using the locator:" + "<" + element.toString() + ">");
			return true;

		} catch (Exception e) {
			System.out.println("Option is not Selected using the locator:" + "<" + element.toString() + ">");
			Assert.fail("Option is not selected, Exception" + e.getMessage());
			return false;
		}

	}

//-------------------------------------------------------------------------------------------------	
// Click methods
//-------------------------------------------------------------------------------------------------	

	public void checkCheckBox(WebElement element) throws InterruptedException {
		boolean clicked = false;
		int attempts = 0;

		while (clicked == false && attempts < 10) {

			try {
				wait.until(ExpectedConditions.elementToBeClickable(element)).click();
				System.out.println("Clicked on the Checkbox " + "<" + element.toString() + ">");
				clicked = true;

			} catch (Exception e) {
				System.out.println("Unable to click on the Checkbox, Exception = " + e.getMessage());
				Assert.fail("Unable to click on the Checkbox" + "<" + element.toString() + ">");
			}
			attempts++;

		}
	}

// -------------------------------------------------------------------------------------------------
// Wait  methods
// -------------------------------------------------------------------------------------------------

	public boolean waitUntilVisibilityOfWebElement(WebElement element) throws InterruptedException {

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("Webelement is visible using the locator:" + "<" + element.toString() + ">");
			return true;

		} catch (Exception e) {
			System.out.println("Webelement is not visible using the locator:" + "<" + element.toString() + ">");
			Assert.fail("Webelement is not visible, Exception" + e.getMessage());
			return false;
		}

	}

	public boolean waitUntilVisibilityOfElementLocated(By byElement) throws InterruptedException {

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
			System.out.println("Webelement is visible using the locator:" + "<" + byElement.toString() + ">");
			return true;

		} catch (Exception e) {
			System.out.println("Webelement is not visible using the locator:" + "<" + byElement.toString() + ">");
			Assert.fail("Webelement is not visible, Exception" + e.getMessage());
			return false;
		}

	}

	public boolean isElementClickable(WebElement element) throws InterruptedException {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			System.out.println("Webelement is clickable using the locator:" + "<" + element.toString() + ">");
			return true;

		} catch (Exception e) {
			System.out.println("Webelement is not clickable using the locator:" + "<" + element.toString() + ">");
			return false;
		}

	}

	public boolean isElementPresent(By byElement) throws InterruptedException {

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
			System.out.println("Element is present using the locator:" + "<" + byElement.toString() + ">");
			return true;

		} catch (Exception e) {
			System.out.println("Element is present using the locator:" + "<" + byElement.toString() + ">");
			return false;
		}

	}

	public boolean waitUntilPreLoadElementDissapear(By byElement) {
		return wait.until((ExpectedConditions.invisibilityOfElementLocated(byElement)));
	}

	public void loadURL(String URL) {
		driver.get(URL);
	}

	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public void isAlertPresent() {

		if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
			System.out.println("Alert is not present");

		} else {
			System.out.println("Alert is present");
		}
	}

	public void closeAlertPopUp() {
		driver.switchTo().alert().dismiss();
		System.out.println("Alert closed");
	}

	public void acceptAlertPopUp() {
		driver.switchTo().alert().accept();
		System.out.println("Alert closed");
	}

	public boolean verifyTheResult(String textToVerify, WebElement element) throws InterruptedException {

		try {

			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertEquals(textToVerify, element.getText().trim());
			System.out.println(
					"Verify the text" + "Expected = " + textToVerify + " Actual = " + element.getText().trim());
			return true;

		} catch (Exception e) {
			System.out.println(
					"Verify the text" + "Expected = " + textToVerify + " Actual = " + element.getText().trim());
			return false;
		}

	}

	public int randomNumberGenerator() {
		Random random = new Random();
		int num = random.nextInt(9990);
		return num;

	}

}

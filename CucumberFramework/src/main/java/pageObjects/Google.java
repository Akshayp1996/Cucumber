package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google {
	WebDriver driver;
	BasePage objBasePage = null;
	ReadExcelData objReadExcelData = null;

	public Google(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		objBasePage = new BasePage(driver);

	}

	public void launchTheBrowser() {
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@FindBy(id = "APjFqb")
	WebElement txtSearch;

	@FindBy(xpath = "(//h3[contains(text(),'Wikipedia')])[1]")
	WebElement firstOccurance;

	public void enterTextInTextBox() throws Exception {
		objBasePage.sendKeys(txtSearch, "Wikipedia");
	}

	public void hitEnter() throws Exception {
		txtSearch.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}

	public void clickOnFirstOccurance() throws Exception {
		objBasePage.waitAndClickElement(firstOccurance);
		Thread.sleep(5000);
	}

}

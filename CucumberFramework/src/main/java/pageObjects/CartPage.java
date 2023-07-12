package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	BasePage objBasePage = null;

	public CartPage(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		objBasePage = new BasePage(driver);
	}

	public void launchTheBrowser() {
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@FindBy(xpath = "//td[text()='FI-SW-01']")
	WebElement productID;

	public void verify_the_shopping_cart_that_selected_product_is_available_in_the_cart_table()
			throws InterruptedException {
		objBasePage.verifyTheResult("FI-SW-01", productID);
		
	}
}

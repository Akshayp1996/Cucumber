
package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	WebDriver driver;
	BasePage objBasePage = null;

	public CheckoutPage(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		objBasePage = new BasePage(driver);
	}

	public void launchTheBrowser() {
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@FindBy(xpath = "//div[@id='SidebarContent']/a[@href='/actions/Catalog.action?viewCategory=&categoryId=FISH']")
	WebElement productName;

	@FindBy(xpath = "//td[text()='Angelfish']/preceding-sibling::td/a")
	WebElement firstProductID;

	@FindBy(xpath = "//td/a[text()='Add to Cart']/parent::td/a[@href='/actions/Cart.action?addItemToCart=&workingItemId=EST-1']")
	WebElement btnFirstItemIDAddToCart;

	@FindBy(xpath = "//a/img[@name='img_cart']")
	WebElement iconCart;

	@FindBy(tagName = "h2")
	WebElement ProductListName;

	@FindBy(xpath = "//a[text()='Proceed to Checkout']")
	WebElement btnProceedToCheckout;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//a[text()='Confirm']")
	WebElement btnConfirm;

	@FindBy(xpath = "//ul[@class='messages']/li[contains(text(),'Thank you, your order has been submitted.')]")
	WebElement SuccessMessage;

	public void click_on_cart_icon() throws InterruptedException {
		objBasePage.waitAndClickElement(iconCart);
	}

	public void verify_the_shopping_cart_should_not_be_empty() throws InterruptedException {
		By emptyCartMessage = By.xpath("//tr/td/b[text()='Your cart is empty.']");
		if (objBasePage.isElementPresent(emptyCartMessage) == true) {
			System.out.println("========Cart is Empty");
		} else {
			System.out.println("=========Cart is not Empty");
		}

	}

	public void click_on_the_proceed_to_checkout_button() throws InterruptedException {
		objBasePage.waitAndClickElement(btnProceedToCheckout);
	}

	public void click_on_continue_button() throws InterruptedException {
		objBasePage.waitAndClickElement(btnContinue);
	}

	public void click_on_confirm_button() throws InterruptedException {
		objBasePage.waitAndClickElement(btnConfirm);
	}

	public void verify_the_success_message_as(String textToVerify) throws InterruptedException {
		objBasePage.verifyTheResult(textToVerify, SuccessMessage);
	}

}

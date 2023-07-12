
package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage {
	WebDriver driver;
	BasePage objBasePage = null;

	public ProductListingPage(WebDriver driver) throws Exception {
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

	@FindBy(tagName = "h2")
	WebElement ProductListName;

	public void select_required_product_from_the_menu_as(String ProductName) throws InterruptedException {
		objBasePage.waitAndClickElement(productName);

	}

	public void verify_the_list_name_as(String ListName) throws InterruptedException {
		objBasePage.verifyTheResult(ListName, (ProductListName));
	}

	public void select_product_id_from_the_table(String string) throws InterruptedException {
		objBasePage.waitAndClickElement(firstProductID);
	}

	public void click_on_add_to_cart_button_of_item_id_from_the_table() throws InterruptedException {
		objBasePage.waitAndClickElement(btnFirstItemIDAddToCart);
	}
}

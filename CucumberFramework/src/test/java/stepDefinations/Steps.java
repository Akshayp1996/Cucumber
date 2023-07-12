package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;

public class Steps {

	WebDriver driver;

	HomePage objHomepage = null;
	CartPage objCartPage = null;
	ProductListingPage objProductListingPage = null;
	CheckoutPage objCheckoutPage = null;

	@Before()
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		objHomepage = new HomePage(driver);
		objCartPage = new CartPage(driver);
		objProductListingPage = new ProductListingPage(driver);
		objCheckoutPage = new CheckoutPage(driver);
	}

	@After()
	public void tearDown() {
		objHomepage = null;
		objCartPage = null;
		objProductListingPage = null;
		objCheckoutPage = null;
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Given("Launch the browser")
	public void launch_the_browser() {

		objHomepage.launchTheBrowser();
	}

	@When("Enter the Pet store url {string}")
	public void enter_the_pet_store_url(String url) {
		driver.get(url);
	}

	@Then("Verify the pet store title")
	public void verify_the_pet_store_title() {
		String strActualTitle = driver.getTitle().trim();
		Assert.assertEquals("JPetStore Demo", strActualTitle);

	}

	// user Registration steps

	@When("Click on Sign In link")
	public void click_on_sign_in_link() throws Exception {

		objHomepage.clickOnSignInLink();
	}

	@When("Click on Register Now link")
	public void click_on_register_now_link() throws Exception {
		objHomepage.click_on_register_now_link();
	}

	@When("Enter User enters UserID")
	public void enter_user_enters_user_id() throws Exception {
		objHomepage.enter_user_enters_user_id();
	}

	@When("Enter New Password and repeat password")
	public void enter_new_password_and_repeat_password() throws Exception {
		objHomepage.enter_new_password_and_repeat_password();
	}

	@When("Enter First Name and Last Name")
	public void enter_first_name_and_last_name() throws Exception {
		objHomepage.enter_first_name_and_last_name();
	}

	@When("Enter email and Phone")
	public void enter_email_and_phone() throws Exception {
		objHomepage.enter_email_and_phone();
	}

	@When("Enter Address1 and Address2")
	public void enter_address1_and_address2() throws Exception {
		objHomepage.enter_address1_and_address2();
	}

	@When("Enter city and State")
	public void enter_city_and_state() throws Exception {
		objHomepage.enter_city_and_state();
	}

	@When("Enter Zip and Country")
	public void enter_zip_and_country() throws Exception {
		objHomepage.enter_zip_and_country();
	}

	@When("Select Language preference and Favourite Category")
	public void select_language_preference_and_favourite_category() throws Exception {
		objHomepage.select_language_preference_and_favourite_category();
	}

	@When("Enable the My checklist and MyBanner checkBox")
	public void enable_the_my_checklist_and_my_banner_check_box() throws Exception {
		objHomepage.enable_the_my_checklist_and_my_banner_check_box();
	}

	@When("click on Save Account Information button")
	public void click_on_save_account_information_button() throws Exception {
		objHomepage.click_on_save_account_information_button();
	}

	@Then("Verify the welcome message")
	public void verify_the_welcome_message() throws Exception {
		objHomepage.verify_the_welcome_message();
	}

	// ============Login page=====================

	@When("Enter username {string} and password {string}")
	public void enter_username_and_password(String username, String password) throws Exception {
		objHomepage.enter_username_and_password(username, password);
	}

	@When("Click on Login button")
	public void click_on_login_button() throws Exception {
		objHomepage.click_on_login_button();
	}

	// ============Add to cart =====================
	@When("Select Required product from the menu as {string}")
	public void select_required_product_from_the_menu_as(String ProductName) throws Exception {
		objProductListingPage.select_required_product_from_the_menu_as(ProductName);
	}

	@Then("Verify the List Name as {string}")
	public void verify_the_list_name_as(String ListName) throws Exception {
		objProductListingPage.verify_the_list_name_as(ListName);
	}

	@When("Select Product ID from the table as {string}")
	public void select_product_id_from_the_table(String ProductID) throws Exception {
		objProductListingPage.select_product_id_from_the_table(ProductID);
	}

	@When("Click on AddToCart button of Item ID from the table")
	public void click_on_add_to_cart_button_of_item_id_from_the_table() throws Exception {
		objProductListingPage.click_on_add_to_cart_button_of_item_id_from_the_table();
	}

	@Then("Verify the Shopping cart that selected product is available in the cart table")
	public void verify_the_shopping_cart_that_selected_product_is_available_in_the_cart_table() throws Exception {
		objCartPage.verify_the_shopping_cart_that_selected_product_is_available_in_the_cart_table();
	}

	@When("Click on Cart Icon")
	public void click_on_cart_icon() throws Exception {
		objCheckoutPage.click_on_cart_icon();
	}

	@Then("Verify the Shopping Cart should not be empty")
	public void verify_the_shopping_cart_should_not_be_empty() throws Exception {
		objCheckoutPage.verify_the_shopping_cart_should_not_be_empty();
	}

	@When("Click on the ProceedToCheckout button")
	public void click_on_the_proceed_to_checkout_button() throws Exception {
		objCheckoutPage.click_on_the_proceed_to_checkout_button();
	}

	@When("Click on Continue button")
	public void click_on_continue_button() throws Exception {
		objCheckoutPage.click_on_continue_button();
	}

	@When("Click on Confirm button")
	public void click_on_confirm_button() throws Exception {
		objCheckoutPage.click_on_confirm_button();
	}

	@Then("Verify the Success message as {string}")
	public void verify_the_success_message_as(String textToVerify) throws Exception {
		objCheckoutPage.verify_the_success_message_as(textToVerify);
	}

	@When("Click on Sign Out button")
	public void click_on_sign_out_button() throws Exception {
		objHomepage.click_on_sign_out_button();
	}

	@Then("Click on home button")
	public void click_on_home_button() throws Exception {
		objHomepage.click_on_home_button();
	}
}

package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	BasePage objBasePage = null;
	ReadExcelData objReadExcelData = null;

	public HomePage(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		objBasePage = new BasePage(driver);
		objReadExcelData = new ReadExcelData();
	}

	public void launchTheBrowser() {
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	WebElement lnkSignIn;

	@FindBy(xpath = "//a[contains(text(),'Register Now!')]")
	WebElement lnkRegisterNow;

	@FindBy(name = "username")
	WebElement inpUserID;

	@FindBy(name = "password")
	WebElement inpPassword;

	@FindBy(name = "repeatedPassword")
	WebElement inpRepeatPassword;

	@FindBy(name = "account.firstName")
	WebElement inpFirstName;

	@FindBy(name = "account.lastName")
	WebElement inpLastName;

	@FindBy(name = "account.email")
	WebElement inpEmail;

	@FindBy(name = "account.phone")
	WebElement inpPhone;

	@FindBy(name = "account.address1")
	WebElement inpAddress1;

	@FindBy(name = "account.address2")
	WebElement inpAddress2;

	@FindBy(name = "account.city")
	WebElement inpCity;

	@FindBy(name = "account.state")
	WebElement inpState;
	@FindBy(name = "account.zip")
	WebElement inpZip;

	@FindBy(name = "account.country")
	WebElement inpCountry;

	@FindBy(name = "account.languagePreference")
	WebElement drpLanguagePreference;

	@FindBy(name = "account.favouriteCategoryId")
	WebElement drpFavouriteCategory;

	@FindBy(name = "account.listOption")
	WebElement chkMyList;

	@FindBy(name = "account.bannerOption")
	WebElement chkMyBanner;

	@FindBy(name = "newAccount")
	WebElement btnSaveAccountInformation;

	@FindBy(id = "WelcomeContent")
	WebElement textWelcomeLocator;

	@FindBy(name = "username")
	WebElement loginUsername;

	@FindBy(name = "password")
	WebElement loginPassowrd;

	@FindBy(name = "signon")
	WebElement btnLogin;

	@FindBy(xpath = "//a[text()='Sign Out']")
	WebElement lnkSignOut;

	@FindBy(id = "LogoContent")
	WebElement iconHomepageLogo;

	public void clickOnSignInLink() throws Exception {

		objBasePage.waitAndClickElement(lnkSignIn);
		System.out.println("Clicked on " + lnkSignIn);
	}

	public void click_on_register_now_link() throws Exception {

		objBasePage.waitAndClickElement(lnkRegisterNow);
	}

	public void enter_user_enters_user_id() throws Exception {
		String UserID = objReadExcelData.getData("UserID");
		objBasePage.sendKeys(inpUserID, UserID);
	}

	public void enter_new_password_and_repeat_password() throws Exception {
		String NewPassword = objReadExcelData.getData("NewPassword");
		String RepeatPassword = objReadExcelData.getData("RepeatPassword");
		objBasePage.sendKeys(inpPassword, NewPassword);
		objBasePage.sendKeys(inpRepeatPassword, RepeatPassword);
	}

	public void enter_first_name_and_last_name() throws Exception {
		String FirstName = objReadExcelData.getData("FirstName");
		String LastName = objReadExcelData.getData("LastName");

		objBasePage.sendKeys(inpFirstName, FirstName);
		objBasePage.sendKeys(inpLastName, LastName);
	}

	public void enter_email_and_phone() throws Exception {
		String Email = "Demo" + objReadExcelData.randomNumberGenerator() + "@gmail.com";
		String Phone = objReadExcelData.getData("Phone") + objReadExcelData.randomNumberGenerator();

		objBasePage.sendKeys(inpEmail, Email);
		objBasePage.sendKeys(inpPhone, Phone);
	}

	public void enter_address1_and_address2() throws Exception {
		String Address1 = objReadExcelData.getData("Address1");
		String Address2 = objReadExcelData.getData("Address2");

		objBasePage.sendKeys(inpAddress1, Address1);
		objBasePage.sendKeys(inpAddress2, Address2);
	}

	public void enter_city_and_state() throws Exception {
		String city = objReadExcelData.getData("City");
		String state = objReadExcelData.getData("State");
		objBasePage.sendKeys(inpCity, city);
		objBasePage.sendKeys(inpState, state);
	}

	public void enter_zip_and_country() throws Exception {
		String zip = objReadExcelData.getData("Zip");
		String country = objReadExcelData.getData("Country");

		objBasePage.sendKeys(inpZip, zip);
		objBasePage.sendKeys(inpCountry, country);
	}

	public void select_language_preference_and_favourite_category() throws Exception {

		String LanguagePreference = objReadExcelData.getData("LanguagePreference");
		String FavouriteCategory = objReadExcelData.getData("FavouriteCategory");

		objBasePage.selectFromDropdownByVisibleText(drpLanguagePreference, LanguagePreference);
		objBasePage.selectFromDropdownByVisibleText(drpFavouriteCategory, FavouriteCategory.toUpperCase());

	}

	public void enable_the_my_checklist_and_my_banner_check_box() throws Exception {

		String MyChecklist = objReadExcelData.getData("MyChecklist");
		String MyBanner = objReadExcelData.getData("MyBanner");

		if (MyChecklist.equals("Yes")) {
			objBasePage.checkCheckBox(chkMyList);
		}
		if (MyBanner.equals("Yes")) {
			objBasePage.checkCheckBox(chkMyBanner);
		}

	}

	public void click_on_save_account_information_button() throws Exception {
		objBasePage.waitAndClickElement(btnSaveAccountInformation);
	}

	public void verify_the_welcome_message() throws Exception {
		String WelcomeName = objReadExcelData.getData("WelcomeName");
		objBasePage.verifyTheResult("Welcome " + WelcomeName + "!", textWelcomeLocator);
	}

	// ============Login page=====================

	public void enter_username_and_password(String username, String password) throws Exception {
		objBasePage.sendKeys(loginUsername, username);
		objBasePage.sendKeys(loginPassowrd, password);

	}

	public void click_on_login_button() throws Exception {
		objBasePage.waitAndClickElement(btnLogin);
	}

	public void click_on_sign_out_button() throws Exception {
		objBasePage.waitAndClickElement(lnkSignOut);
	}

	public void click_on_home_button() throws Exception {
		objBasePage.waitAndClickElement(iconHomepageLogo);
	}

}

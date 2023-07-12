package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import freemarker.core.ReturnInstruction.Return;

public class DriverFactory {

	public static WebDriver driver;

	public WebDriver getDriver() {

		try

		{
			ReadConfigFile file = new ReadConfigFile();
			String browserName = file.getBrowser();

			switch (browserName) {
			case "chrome":
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", Constants.Chrome_Driver_Directory);
					this.driver = new ChromeDriver();
				}
				break;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return driver;

	}

}

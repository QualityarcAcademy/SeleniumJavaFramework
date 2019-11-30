package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import reusableLib.Orangehrm;

public class HomePageServiceNow extends Orangehrm {
	public HomePageServiceNow(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

}

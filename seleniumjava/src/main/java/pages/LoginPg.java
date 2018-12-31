package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import reusableLib.Orangehrm;


public class LoginPg extends Orangehrm{
	public LoginPg(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}

	/**
	 * Stores all web elements (Page objects - Fields)
	 * 
	 * This uses @FindBy and @FindBys methods
	 * 
	 */

	@FindBy(how=How.ID,using="txtUsername") 
	private WebElement Username;

	@FindBy(how=How.ID, using = "txtPassword") 
	private WebElement Password;

	@FindBy(how=How.ID, using = "btnLogin") 
	private WebElement Login;

	/**
	 * Stores all login page actions (Object's methods )
	 * 
	 * @param Username, password
	 * @return 
	 * @return to dashboard page
	 */

	public LoginPg enterUsername(String username) {
		typeInto(Username, username);
		return this;
	}

	public LoginPg enterPassword(String password) {
		typeInto(Password, password);
		return this;
	}


	public DashboardPg clickLoginBtn() {
		click(Login);
		return new DashboardPg(driver);
	}

}
